package com.example.ejemplo_21_11.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ejemplo_21_11.R


@Composable
fun MyMaps(navController: NavController) {
    Image(painter = painterResource(id = R.drawable.mapa),
        contentDescription = "Ejemplo google maps Valencia",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
    )

    Image(painter = painterResource(id = R.drawable.logo),
        contentDescription = "Logo aplicación",
        modifier = Modifier
            .padding(150.dp, 175.dp)
            .height(50.dp)
            .clickable { navController.navigate("mapasEstablecimientos") }
    )

}