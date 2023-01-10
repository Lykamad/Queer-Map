package com.example.ejemplo_21_11.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ejemplo_21_11.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopBar(scope: CoroutineScope, scaffoldState: ScaffoldState){
    TopAppBar(
        title = {
            Image(painter = painterResource(id = R.drawable.logo_2),
                contentDescription = "Logo aplicación",
                modifier = Modifier
                    .padding(10.dp)
                    .height(35.dp)
            )
            Text(text = "Queer Map")

        },
        contentColor = Color.Black,
        elevation = 10.dp,
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = Color.Black)
            }
        }
    )
}


