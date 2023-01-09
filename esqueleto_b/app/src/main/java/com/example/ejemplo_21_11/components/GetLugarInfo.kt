package com.example.ejemplo_21_11.components

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
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
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Preview
@Composable
fun GetLugarInfo(){
    var lugarName by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxWidth(),
           verticalArrangement = Arrangement.Center,
           HorizontalAlignment = Alignment.CenterHorizontally
        ) {
        TextField(value = lugarName,
                  onValueChange ={ lugarName = it},
                  label={ Text(text = "Introduce el nombre del lugar")}
            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "ACEPTAR",
                     fontSize = 20.sp
                )
            }

    }
}

@Composable

fun CreateLugarCard(selectedLugar: Lugar) {
    Card (
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,
        border = BorderStroke(2.dp, Color.DarkGray),
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
        )
        {
            Image(painter = painterResource(id = selectedLugar.imageID),
                contentDescription = selectedLugar.lugarName,
                modifier = Modifier.fillMaxWidth(),
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
fun CreateLugarView(fichaLugar: Lugar){
    Column(modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
        ) {
        Image(painter = painterResource(id = fichaLugar.imageID),
            contentDescription = "Guakame",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop
            )
        Box(modifier = Modifier
            .fillMaxWidth()
        ){
            Text(text = fichaLugar.lugarName,
            modifier = Modifier
                .padding(125.dp, 10.dp),
                color = Color.Blue,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Cursive,
                fontSize = 30.sp,
                textDecoration = TextDecoration.Underline
                )
            var checked by remember { mutableStateOf(false)}
            IconToggleButton(checked = checked, onCheckedChange = {checked = it},
            modifier = Modifier
                .padding(10.dp, 10.dp),
                ) {
                Icon(painter = painterResource(if (checked) R.drawable.favorite
                else R.drawable.border), contentDescription = if (checked) "Añadir a favoritos"
                else "Quitar de favoritos",
                tint = Color.Red
                )
                
            }
        }
        
        Text(
            text = stringResource(id = fichaLugar.lugarInfo),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(10.dp, 10.dp),
            lineHeight = 2.em,
            )
        val context = LocalContext.current
        Button(onClick = {
            Toast.makeText(context, "Gracias por pulsar!", Toast.LENGTH_LONG).show()
        },
        shape = CutCornerShape(10),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue),


            border = BorderStroke(2.dp,Color.Black),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 10.dp,
                pressedElevation = 15.dp,
                disabledElevation = 0.dp)
        
            ) {
            
            Text(text = "Cerrar",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier
                    .alignByBaseline()
            )
        }

    }
}