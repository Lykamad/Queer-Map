package com.example.ejemplo_21_11.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ejemplo_21_11.R
import com.example.ejemplo_21_11.ui.theme.Blue1
import com.example.ejemplo_21_11.ui.theme.Orange
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

//Clase para los comentarios de usuarios predefinidos
data class Comentarios (
    val Foto: Int,
    val Nombre: String,
    val Comentario: String
        )

//Array para colocar usuarios predefinidos
val listaComentarios = arrayListOf<Comentarios>(
    Comentarios(R.drawable.perfil1, "María", "Un sitio estupendo, buena atención. Sin altercados y buen ambiente."),
    Comentarios(R.drawable.perfil2, "Rosa", "Todo muy rico. La gente muy amable. "),
    Comentarios(R.drawable.perfil3, "Juan", "La comida increíble y el personal también. Pienso volver."),
    Comentarios(R.drawable.perfil4, "Eric", "Servicio impecable."),
    Comentarios(R.drawable.perfil5, "Anna", "Sin incidencias, espacio seguro."),
    Comentarios(R.drawable.perfil6, "Noah", "Fui con mi pareja y todo perfecto, camareros encantadores.")
)

//Definimos la card para el restaurante
@Composable
fun ViewRestaurante() {
    Card(modifier = Modifier
            .width(450.dp)
            .padding(10.dp)
            .height(160.dp),
        backgroundColor = Color.Gray,
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(modifier = Modifier
            .height(100.dp)
        )
        {
            Image(painter = painterResource(id=R.drawable.caboa),
                contentDescription = "Restaurante Caboa",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop)
        }
    }

    Box( modifier = Modifier
        .padding(top = 175.dp)
        .padding(10.dp)
        .clip (RoundedCornerShape(20.dp))
        .background(Orange)
    ) {
        Column(modifier = Modifier
            .padding(20.dp,0.dp,185.dp)) {
            Text(
                text = "CABOA",
                modifier = Modifier
                    .padding(0.dp,10.dp,0.dp,0.dp),
                // .padding(top = 220.dp),
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = Color.Black
            )

            Text(
                text = "Restaurante",
                modifier = Modifier
                    .padding(0.dp,3.dp),
                // .padding(top = 265.dp),
                fontSize = 16.sp,
                color = Color.Black
            )

            Text(
                text = "C/ Correos, 10 Valencia",
                modifier = Modifier
                    .padding(0.dp,5.dp),
                // .padding(top = 295.dp),
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
    Text(
        text = "Comentarios",
        modifier = Modifier
            .padding(20.dp,10.dp,0.dp,0.dp)
            .padding(top = 298.dp),
        fontSize = 24.sp,
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        color = Color.Black
    )
}

@Composable
fun MapasEstablecimientos(navController: NavController) {

    ViewRestaurante()

    LazyColumn(modifier = Modifier .padding(top=350.dp) .padding(bottom = 75.dp)){
      items(listaComentarios) {comentario ->
            CreateComment(comentario = comentario)
      }
    }
}

@Composable
fun CreateComment(comentario: Comentarios) {


    Row( modifier = Modifier .padding(10.dp)) {

        Image(painter = painterResource(id = comentario.Foto),
            contentDescription = comentario.Nombre,
            modifier = Modifier
                .size(70.dp)
                .padding(1.dp)
                .clip(CircleShape)
                .border(0.5.dp, Blue1, CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier
            .padding(8.dp)
        )

        Column(modifier = Modifier
            .weight(1f)
        ) {
            Text(text = comentario.Nombre,
                fontWeight = FontWeight.Bold
            )
            Text(text = comentario.Comentario)
        }

       /* IconToggleButton(checked = Checked,
            onCheckedChange = {Checked = it}) {
            Icon(painter = painterResource(id = if (Checked) R.drawable.like
            else R.drawable.dislike),
                contentDescription = if (Checked) "Like al comentario"
                else "Dislike al comentario"
            )
        }*/
    }
}

