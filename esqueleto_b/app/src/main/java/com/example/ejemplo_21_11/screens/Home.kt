package com.example.ejemplo_21_11.screens

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
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
fun CreateLugarCard(selectedLugar: Lugar) {
    Card(
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,

        modifier = Modifier
            .width(450.dp)
            .padding(10.dp)
            .height(200.dp),

    ) {

        Box(
            modifier = Modifier
                .height(100.dp)
        )
        {
            Image(
                painter = painterResource(id = selectedLugar.imageID),
                contentDescription = selectedLugar.lugarName,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 160f
                        )
                    )
            )
            Text(
                text = selectedLugar.lugarName,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp),
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Italic
            )
        }
    }
}





@Composable
fun Home(navController: NavController) {

    Column() {
        LazyColumn(modifier = Modifier.padding(10.dp)) {

            items(listaLugares) { selectedLugar ->
                CreateLugarCard(selectedLugar = selectedLugar)
            }
        }
    }
}

