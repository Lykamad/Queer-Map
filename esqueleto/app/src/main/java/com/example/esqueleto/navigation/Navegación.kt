package com.example.esqueleto.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.esqueleto.database.UserEntity
import com.example.esqueleto.model.UserViewModel
import com.example.esqueleto.screens.ListUsers
import com.example.esqueleto.screens.ProfileEdit

@Composable
fun Navegacion (navController : NavHostController, userViewModel: UserViewModel) {
//Si no lo ponemos a observar no actuliza la vista cuando añade un nuevo usuario
    val userViewModelList : List<UserEntity> by userViewModel.readAllData.observeAsState(listOf())

    NavHost(navController = navController, startDestination = "listarUsuarios"){
        composable("listarUsuarios"){ ListUsers(userViewModel) }
        composable("crearUsuarios"){ ProfileEdit(navController, userViewModel, userViewModelList) }} //el orden importa //en el 3r val espera UserEntity pero le paso User -> ERROR
}