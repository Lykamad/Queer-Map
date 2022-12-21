package com.example.esqueleto.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopBar(scope: CoroutineScope, scaffoldState: ScaffoldState){
    TopAppBar(
        title = { Text(text = "Ciudades del Mundo") },
        contentColor = Color.White,
        elevation = 10.dp,
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(imageVector = Icons.Default.Menu,
                    contentDescription = "Menu")
            }
        }
    )
}