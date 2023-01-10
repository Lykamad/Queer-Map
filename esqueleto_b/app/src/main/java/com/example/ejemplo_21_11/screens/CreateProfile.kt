package com.example.ejemplo_21_11.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.ejemplo_21_11.R
import com.example.ejemplo_21_11.database.ProfileEntity
import com.example.ejemplo_21_11.model.UserViewModel
import com.example.ejemplo_21_11.ui.theme.Blue1


@Composable
fun CreateProfile(navController: NavController, mUserViewModel: UserViewModel, listProfile: List<ProfileEntity>
) {
    val profilePhoto: String by mUserViewModel.profilePic.observeAsState(initial = "")
    val profileName: String by mUserViewModel.profileName.observeAsState(initial = "")
    val profilePronouns: String by mUserViewModel.profilePronouns.observeAsState(initial = "")
    val profileDescription: String by mUserViewModel.profileDescription.observeAsState(initial = "")
    val profileSexuality: String by mUserViewModel.profileSexuality.observeAsState(initial = "")
    val profileLocation: String by mUserViewModel.profileLocation.observeAsState(initial = "")


    // Cargar la foto que elija el usuario o el icono predef. si no se le ha proporcionado foto.


    //Seleccionar y cambiar foto
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {uri: Uri? ->
        uri?.let { profilePhoto}
    }


    Column(
        Modifier.padding(8.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .size(80.dp)
                .border(0.5.dp, Blue1, CircleShape)
                .padding(1.dp)
                .clickable {launcher.launch("image/*") }
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            painter = rememberAsyncImagePainter(

                if (profilePhoto.isEmpty())
                    R.drawable.user
                else
                    ImageRequest
                        .Builder(LocalContext.current)
                        .data(data = profilePhoto)
                        .build(),
            ),
            contentDescription = profileName
        )
        Spacer(Modifier.size(10.dp))
        OutlinedTextField( //para que el usuario pueda escribir
            value = profileName,
            onValueChange = { mUserViewModel.onProfileNameChange(it)}, //cuando el ususrio teclee, es un evento {}
            label = { Text(text = "Introduce tu nombre") },
            modifier = Modifier.padding(4.dp),
            textStyle = TextStyle(fontSize = 16.sp)
        )
        Spacer(Modifier.size(10.dp))
        OutlinedTextField(
            value = profilePronouns,
            onValueChange = { mUserViewModel.onProfilePronounsChange(it)},
            label = { Text(text = "Introduce tus pronombres") },
            modifier = Modifier.padding(4.dp),
            textStyle = TextStyle(fontSize = 16.sp)
        )
        Spacer(Modifier.size(10.dp))
        OutlinedTextField(
            value = profileDescription,
            onValueChange = { mUserViewModel.onProfileDescriptionChange(it)},
            label = { Text(text = "Dinos algo sobre ti") },
            modifier = Modifier.padding(4.dp),
            textStyle = TextStyle(fontSize = 16.sp)
        )
        Spacer(Modifier.size(10.dp))
        OutlinedTextField(
            value = profileSexuality,
            onValueChange = { mUserViewModel.onProfileSexualityChange(it)},
            label = { Text(text = "Introduce tu orientación sexual") },
            modifier = Modifier.padding(4.dp),
            textStyle = TextStyle(fontSize = 16.sp)
        )
        OutlinedTextField(
            value = profileLocation,
            onValueChange = { mUserViewModel.onProfileLocationChange(it)},
            label = { Text(text = "Introduce tu ubicación") },
            modifier = Modifier.padding(4.dp),
            textStyle = TextStyle(fontSize = 16.sp)
        )
        Spacer(Modifier.size(15.dp))
        Button(onClick = { val newProfile = ProfileEntity(null, profilePhoto, profileName,
            profilePronouns, profileDescription, profileSexuality, profileLocation)

            mUserViewModel.addProfile(newProfile)
            navController.navigate("verPerfil")
        })
        {
            Text(text = "Guardar")
        }

    }

}





