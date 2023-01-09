package com.example.ejemplo_21_11.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.ejemplo_21_11.R

// Set of Material typography styles to start with
val Typography = Typography(
    // Drawer (logo(24.sp)+items(en fun)), "Cambiar foto de perfil"
    body1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 16.sp
    ),
    //textfield
    subtitle1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        fontSize = 16.sp
    ),
   /* h1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 16.sp
    ),
    h2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 16.sp
    ),
    h3 = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 16.sp
    ),
    h4 = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 16.sp
    ),
    h5 = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 16.sp
    ),*/
    //top bar
    h6 = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 24.sp
    ),
   /* button = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 16.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 16.sp
    ),
    overline = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 16.sp
    ),
   */
)

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */