package com.example.esqueleto.screens

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.example.esqueleto.database.LocationsEntity
import com.example.esqueleto.model.UserViewModel

@Composable
fun ProfileEdit(navController: NavController, mUserViewModel: UserViewModel, listUsers: List<LocationsEntity>
) {
    val userPhoto: String by mUserViewModel.userPhoto.observeAsState(initial = "")
    val userName: String by mUserViewModel.userName.observeAsState(initial = "")
    val userPhone: String by mUserViewModel.userPhone.observeAsState(initial = "")
    val userEmail: String by mUserViewModel.userEmail.observeAsState(initial = "")
    val userCity: String by mUserViewModel.userCity.observeAsState(initial = "")

    Column(
        Modifier.padding(8.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .size(80.dp)
                .border(0.5.dp, Color.Blue, CircleShape)
                .padding(1.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            painter = rememberAsyncImagePainter(
                ImageRequest
                    .Builder(LocalContext.current)
                    .data(data = Uri.parse(userPhoto))
                    .build()
            ),
            contentDescription = userName
        )
        Spacer(Modifier.size(10.dp))
        OutlinedTextField( //para que el usuario pueda escribir
            value = userName,
            onValueChange = { mUserViewModel.onUserNameChange(it)}, //cuando el ususrio teclee, es un evento {}
            label = { Text(text = "Introduce tu nombre") },
            modifier = Modifier.padding(4.dp),
            textStyle = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic)
        )
        Spacer(Modifier.size(10.dp))
        OutlinedTextField(
            value = userPhone,
            onValueChange = { mUserViewModel.onUserPhoneChange(it)},
            label = { Text(text = "Introduce tu número") },
            modifier = Modifier.padding(4.dp),
            textStyle = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic)
        )
        Spacer(Modifier.size(10.dp))
        OutlinedTextField(
            value = userEmail,
            onValueChange = { mUserViewModel.onUserEmailChange(it)},
            label = { Text(text = "Introduce tu email") },
            modifier = Modifier.padding(4.dp),
            textStyle = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic)
        )
        Spacer(Modifier.size(10.dp))
        OutlinedTextField(
            value = userCity,
            onValueChange = { mUserViewModel.onUserCityChange(it)},
            label = { Text(text = "Introduce tu ciudad") },
            modifier = Modifier.padding(4.dp),
            textStyle = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic)
        )
        Spacer(Modifier.size(15.dp))
        Button(onClick = { val newLocation = LocationsEntity(null, userName, userEmail, userPhone,
           "https://cdn.pixabay.com/photo/2016/07/11/15/43/woman1509956_960_720.jpg", userCity)

            mUserViewModel.addLocation(newLocation)
            navController.navigate("listarUsuarios")
        }) {
            Text(text = "Añadir")
        }
    }

}