package com.example.ejemplo_21_11.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.ejemplo_21_11.R
import com.example.ejemplo_21_11.model.UserViewModel


//Por su complejidad, definimos una función para la imagen de perfil. Se permite al usuario elegir la foto que quiera.
@Composable
fun ChangeProfilePic (mUserViewModel: UserViewModel){
    //Guardar estado de la foto de perfil
    val imageUri = rememberSaveable { mutableStateOf("") }
    // Cargar la foto que elija el usuario o el icono predef. si no se le ha proporcionado foto.
    val painter = rememberAsyncImagePainter(
        if (imageUri.value.isEmpty())
            R.drawable.user
        else
            imageUri.value
    )
    //Seleccionar y cambiar foto
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {uri: Uri? ->
        uri?.let { imageUri.value = it.toString()}
    }

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            shape = CircleShape,
            modifier = Modifier
                .padding(8.dp)
                .size(100.dp)
        ) {
           Image(painter = painter,
               contentDescription = "Foto de perfil",
           modifier = Modifier
               .wrapContentSize()
               //Al clickar sobre la foto nos redirige a la galería para selecionar una foto de perfil, le indicamos que permita todo tipo de imágenes
               .clickable { launcher.launch("image/*") },
               contentScale = ContentScale.Crop
           )

        }

        Text(
            text = "Cambiar foto de perfil"
        )
    }

}

//Definimos una función para optimizar código, específica para los textfields
@Composable
fun MyTextFields(
    label:String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    value:String,
    onValueChanged: (String) -> Unit
) {

    OutlinedTextField(
        value = value,
        label = { Text(text = label)},
        onValueChange = onValueChanged,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions
    )

}



@Composable
fun MyProfile(mUserViewModel: UserViewModel) {


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(18.dp),
        horizontalAlignment = Alignment.Start
    ) {

        //Se carga la función de la foto de perfil
        ChangeProfilePic(mUserViewModel)


        MyTextFields(
            label = "Nombre",
            value = mUserViewModel.profileUserName,
            onValueChanged = {mUserViewModel.onProfileUserNameChange(it)}
        )


        MyTextFields(
            label = "Pronombres",
            value = mUserViewModel.profilePronouns,
            onValueChanged = {mUserViewModel.onProfilePronounsChange(it)}
        )


        MyTextFields(
            label = "Sobre Mí",
            value = mUserViewModel.profileDescription,
            onValueChanged = {mUserViewModel.onProfileDescriptionChange(it)}
        )

        MyTextFields(
            label = "Orientación",
            value = mUserViewModel.profileSexuality,
            onValueChanged = {mUserViewModel.onProfileSexualityChange(it)}
        )

        MyTextFields(
            label = "Ubicación",
            value = mUserViewModel.profileLocation,
            onValueChanged = {mUserViewModel.onProfileLocationChange(it)}
        )

    }


}
    



