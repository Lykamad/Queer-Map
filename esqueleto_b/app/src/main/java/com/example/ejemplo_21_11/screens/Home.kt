package com.example.ejemplo_21_11.screens

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.ejemplo_21_11.Lugar
import com.example.ejemplo_21_11.components.BottomBar
import com.example.ejemplo_21_11.components.Drawer
import com.example.ejemplo_21_11.components.TopBar
import com.example.ejemplo_21_11.navigation.Navegacion
import com.example.ejemplo_21_11.model.UserViewModel
import com.example.ejemplo_21_11.model.UserViewModelFactory
import com.example.ejemplo_21_11.ui.theme.Ejemplo_21_11Theme

@Preview
@Composable

fun Home(){
    val misLugares = listOf<Lugar>(
        Lugar(R.drawable.guakame, "Guakame", R.string.GuakameDescrip)
    )
    
    Column() {
        Row(modifier = Modifier.padding(10.dp)) {
            misLugares.forEach { index ->
                CreateLugarCard(index)
                Spacer(
                    modifier = Modifier.size(
                        6.dp
                    )
                )
            }
        }

        Spacer(modifier = Modifier.size(10.dp))
        CreateLugarView(fichaLugar = misLugares[1])

    }
}

@Composable
fun Home1(misLugares: List<Lugar>){
    Column() {
        LazyRow(modifier = Modifier.padding(10.dp)){
            items(misLugares){index -> CreateLugarCard(index)
            Spacer(modifier = Modifier.size(6.dp))
            CreateLugarView(fichaLugar = misLugares[1])}
        }
        
    }
}