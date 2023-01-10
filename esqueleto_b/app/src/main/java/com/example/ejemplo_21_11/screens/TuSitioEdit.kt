package com.example.ejemplo_21_11.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ejemplo_21_11.R
import com.example.ejemplo_21_11.database.UserEntity
import com.example.ejemplo_21_11.model.UserViewModel

@Composable
fun ProfileEdit(navController: NavController, mUserViewModel: UserViewModel, listUsers: List<UserEntity>
) {
    val userPhoto: String by mUserViewModel.userPhoto.observeAsState(initial = "")
    val userName: String by mUserViewModel.userName.observeAsState(initial = "")
    val userPhone: String by mUserViewModel.userPhone.observeAsState(initial = "")
    val userEmail: String by mUserViewModel.userEmail.observeAsState(initial = "")
    val userCity: String by mUserViewModel.userCity.observeAsState(initial = "")
    val europe: Boolean by mUserViewModel.europe.observeAsState(initial = false)

    Column(
        Modifier.padding(8.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {

        OutlinedTextField( //para que el usuario pueda escribir
            value = userName,
            onValueChange = { mUserViewModel.onUserNameChange(it)}, //cuando el ususrio teclee, es un evento {}
            label = { Text(text = "Introduce el nombre del lugar") },
            modifier = Modifier.padding(4.dp),
            textStyle = TextStyle(
                fontSize = 16.sp)
        )
        Spacer(Modifier.size(10.dp))
        OutlinedTextField(
            value = userPhone,
            onValueChange = { mUserViewModel.onUserPhoneChange(it)},
            label = { Text(text = "Introduce el tipo de local") },
            modifier = Modifier.padding(4.dp),
            textStyle = TextStyle(
                fontSize = 16.sp)
        )
        Spacer(Modifier.size(10.dp))
        OutlinedTextField(
            value = userCity,
            onValueChange = { mUserViewModel.onUserCityChange(it)},
            label = { Text(text = "Introduce la dirección") },
            modifier = Modifier.padding(4.dp),
            textStyle = TextStyle(
                fontSize = 16.sp)
        )

        Spacer(Modifier.size(15.dp))
        Button(onClick = { val newUser = UserEntity(null, userName, userEmail, userPhone,
           "https://cdn.pixabay.com/photo/2016/07/11/15/43/woman1509956_960_720.jpg", userCity, europe)

            mUserViewModel.addUser(newUser)
            navController.navigate("listarUsuarios")
        }) {
            Text(text = "Añadir")
        }
    }

}