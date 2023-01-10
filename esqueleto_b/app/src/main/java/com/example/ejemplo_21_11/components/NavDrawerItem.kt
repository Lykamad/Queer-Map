package com.example.ejemplo_21_11.components

import android.media.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.ejemplo_21_11.R

sealed class NavDrawerItem(
    var ruta: String,
    var icono: ImageVector,
    var texto: String
){
<<<<<<< Updated upstream
    object Inicio: NavDrawerItem( "listarUsuarios", Icons.Default.Home, "Inicio")
    object Favoritos: NavDrawerItem( "miMapa", Icons.Default.LocationOn, "Mapas")
    object CrearPerfil: NavDrawerItem( "crearPerfil", Icons.Default.Edit, "Crear perfil")
    object Perfil: NavDrawerItem( "verPerfil", Icons.Default.Person, "Ver perfiles")
=======
    object Inicio: NavDrawerItem( "inicio", Icons.Default.Home, "Inicio")
    object Favoritos: NavDrawerItem( "miMapa", Icons.Default.Star, "Mapas")
    object Perfil: NavDrawerItem( "miPerfil", Icons.Default.Person, "Mi Perfil")
>>>>>>> Stashed changes
}

