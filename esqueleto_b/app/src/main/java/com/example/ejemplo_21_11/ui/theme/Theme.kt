package com.example.ejemplo_21_11.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorQueerMapTheme = darkColors(
    primary = Blue1,
    primaryVariant = Pink,
    secondary = Orange,
    background = Blue2
)

private val LightColorQueerMapTheme = lightColors(
    primary = Blue1,
    primaryVariant = Pink,
    secondary = Orange,
    background = Blue2
)

/* Other default colors to override
background = Color.White,
surface = Color.White,
onPrimary = Color.White,
onSecondary = Color.Black,
onBackground = Color.Black,
onSurface = Color.Black,
*/

@Composable
fun QueerMapTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorQueerMapTheme
    } else {
        LightColorQueerMapTheme
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}