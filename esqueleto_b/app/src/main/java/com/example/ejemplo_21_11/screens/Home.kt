package com.example.ejemplo_21_11.screens

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.ejemplo_21_11.R
import com.example.ejemplo_21_11.components.BottomBar
import com.example.ejemplo_21_11.components.Drawer
import com.example.ejemplo_21_11.components.TopBar
import com.example.ejemplo_21_11.navigation.Navegacion
import com.example.ejemplo_21_11.model.UserViewModel
import com.example.ejemplo_21_11.model.UserViewModelFactory
import com.example.ejemplo_21_11.ui.theme.QueerMapTheme

data class Lugar (
    val imageID: Int,
    val lugarName: String,
)

//Array para colocar usuarios predefinidos
val listaLugares= arrayListOf<Lugar>(
    Lugar(R.drawable.guakame, "Guakame"),
    Lugar(R.drawable.caboa, "Caboa"),
    Lugar(R.drawable.cafe_de_las_horas, "Cafe de las Horas"),
    Lugar(R.drawable.living_bakkali, "Living Bakkali"),
    Lugar(R.drawable.asoko, "Asoko"),
    Lugar(R.drawable.la_sastreria, "La Sastreria")
)

@Composable
fun CreateLugarCard() {
    Card(
        modifier = Modifier
            .width(450.dp)
            .padding(10.dp)
            .height(200.dp),
        backgroundColor = Color.Gray,
        shape = RoundedCornerShape(20.dp)
    ) {

        Box(modifier = Modifier
            .height(100.dp)
        )
        {
            Image(painter = painterResource(id = selectedLugar.imageId), contentDescription = selectedLugar.lugarName )
        }