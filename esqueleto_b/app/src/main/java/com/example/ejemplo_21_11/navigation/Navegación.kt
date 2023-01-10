package com.example.ejemplo_21_11.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ejemplo_21_11.database.ProfileEntity
import com.example.ejemplo_21_11.database.UserEntity
import com.example.ejemplo_21_11.model.UserViewModel
import com.example.ejemplo_21_11.screens.*

@Composable
fun Navegacion (navController : NavHostController, userViewModel: UserViewModel) {
//Si no lo ponemos a observar no actuliza la vista cuando añade un nuevo usuario
    val userViewModelList : List<UserEntity> by userViewModel.readAllData.observeAsState(listOf())
    val profileViewModelList : List<ProfileEntity> by userViewModel.readAllDataProfile.observeAsState(listOf())

    NavHost(navController = navController, startDestination = "inicio"){
        composable("listarUsuarios") {ListUsers(userViewModel) }
        composable("verPerfil") { ViewProfile(userViewModel) }
        composable("crearUsuarios") {ProfileEdit(navController, userViewModel, userViewModelList) } //el orden importa //en el 3r val espera UserEntity pero le paso User -> ERROR
        composable("crearPerfil") {CreateProfile(navController, userViewModel,  profileViewModelList)}
        composable("miMapa") {MyMaps(navController)}
        composable("mapasEstablecimientos") { MapasEstablecimientos(navController) }
        composable("inicio") { Home(navController) }
   }
}