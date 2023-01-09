package com.example.ejemplo_21_11.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Drawer(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController) {

    val listItems = listOf<NavDrawerItem>(NavDrawerItem.Inicio, NavDrawerItem.Favoritos, NavDrawerItem.Perfil)
    val rutaActual = navController.currentBackStackEntry?.destination?.route

    Column(){
        /*Image(painter = painterResource(id = com.example.t2_examen.R.drawable.mapa),
            contentDescription = "Mapa",
            modifier = Modifier
                .background(Color.White)
                .height(200.dp)
                .fillMaxWidth()
                .padding(10.dp)
        )*/
        Text (modifier = Modifier
            .padding(20.dp),
            text = "Queer map",
            fontSize = 24.sp,
            //fontWeight = FontWeight.Bold, //no funciona
            color = Color.Black)
        /*Spacer(modifier = Modifier
            .height(10.dp)
            .fillMaxWidth()
            .padding(10.dp)
        )*/
        listItems.forEach{
            DrawerItem(
                item = it,
                selected = (rutaActual == it.ruta),
                onclick = {navController.navigate(it.ruta)
                    scope.launch {scaffoldState.drawerState.close()}
                })
        }
    }
}

@Composable
fun DrawerItem(item: NavDrawerItem,
               selected:Boolean,
               onclick:(NavDrawerItem)->Unit)
{
//    val itemBackground = if(selected) Color.Gray else Color.Transparent

    Row(modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
//          .background(itemBackground)
            .padding(10.dp)
            .clickable { onclick(item) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(imageVector = item.icono,
            contentDescription = item.texto,
            colorFilter = ColorFilter.tint(Color.Black),
            modifier = Modifier
                .height(35.dp)
                .width(35.dp)
        )
        Spacer(modifier = Modifier.padding(6.dp))
        Text(text = item.texto,
            fontSize = 18.sp,
            //fontWeight = FontWeight.Bold, //no funciona
            color = Color.Black)
    }
}