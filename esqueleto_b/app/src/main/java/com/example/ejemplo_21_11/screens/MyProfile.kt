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
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.ejemplo_21_11.R


//Por su complejidad, definimos una función para la imagen de perfil. Se permite al usuario elegir la foto que quiera.
@Composable
fun ChangeProfilePic (){
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
        horizontalAlignment = Alignment.CenterHorizontally
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
    }

}



@Composable
fun MyProfile() {


    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {

        //Se carga la función de la foto de perfil
        ChangeProfilePic()

        Text(
            text = "Cambiar foto de perfil"
        )

        Text(
            text = "Nombre"
        )

        Text(
            text = "Pronombres"
        )

        Text(
            text = "Ubicación"
        )


        }


}
    



