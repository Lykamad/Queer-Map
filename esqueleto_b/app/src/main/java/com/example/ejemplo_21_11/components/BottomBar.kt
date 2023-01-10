package com.example.ejemplo_21_11.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ejemplo_21_11.R

@Composable
fun BottomBar(navController: NavController){ //pasar navcontroller para enlazar navegación
    var selectedIcon = remember{ mutableStateOf(0) }
    BottomNavigation(elevation = 15.dp)
    {
        //cada BottomNavigationItem es un boton
        BottomNavigationItem(
            selected = (selectedIcon.value==0),
            onClick = { selectedIcon.value = 0
                navController.navigate("Inicio")},
            icon = { Icon(imageVector = Icons.Default.Home,
                contentDescription = "Home",
                tint = Color.White)
            },
            //label = { Text(text = "Inicio") }
        )
        BottomNavigationItem(
            selected = (selectedIcon.value==0),
            onClick = { selectedIcon.value = 1
                navController.navigate("miMapa")
            },
            icon = { Image(painter = painterResource(id = R.drawable.map),//Icons.Default.Favorite,
                contentDescription = "Mapa")
            },
            //label = { Text(text = "Mapa") }
        )
        BottomNavigationItem(
            selected = (selectedIcon.value==0),
            onClick = { selectedIcon.value = 2
                navController.navigate("verPerfil")
            },
            icon = { Icon(imageVector = Icons.Default.Person,
                contentDescription = "Perfil",
                tint = Color.White)
            },
            //label = { Text(text = "Mi Perfil") }
        )
    }
}