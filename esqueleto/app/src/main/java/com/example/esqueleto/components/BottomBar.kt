package com.example.esqueleto.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BottomBar(navController: NavController){ //pasar navcontroller para enlazar navegación
    var selectedIcon = remember{ mutableStateOf(0) }
    BottomNavigation(elevation = 15.dp)
    {
        //cada BottomNavigationItem es un boton
        BottomNavigationItem(
            selected = (selectedIcon.value==0),
            onClick = { selectedIcon.value = 0
                navController.navigate("listarUsuarios")},
            icon = { Icon(imageVector = Icons.Default.Home,
                contentDescription = "Home",
                tint = Color.White)
            },
            label = { Text(text = "Inicio") }
        )
        BottomNavigationItem(
            selected = (selectedIcon.value==0),
            onClick = { selectedIcon.value = 1
                navController.navigate("listarUsuarios")
            },
            icon = { Icon(imageVector = Icons.Default.Favorite,
                contentDescription = "Favoritos",
                tint = Color.White)
            },
            label = { Text(text = "Favoritos") }
        )
        BottomNavigationItem(
            selected = (selectedIcon.value==0),
            onClick = { selectedIcon.value = 2
                navController.navigate("listarUsuarios")
            },
            icon = { Icon(imageVector = Icons.Default.Person,
                contentDescription = "Perfil",
                tint = Color.White)
            },
            label = { Text(text = "Perfil") }
        )
    }
}