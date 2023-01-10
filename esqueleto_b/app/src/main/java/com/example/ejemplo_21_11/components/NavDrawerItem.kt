package com.example.ejemplo_21_11.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavDrawerItem(
    var ruta: String,
    var icono: ImageVector,
    var texto: String
){
    object Inicio: NavDrawerItem( "listarUsuarios", Icons.Default.Home, "Inicio")
    object Favoritos: NavDrawerItem( "miMapa", Icons.Default.LocationOn, "Mapas")
    object CrearPerfil: NavDrawerItem( "crearPerfil", Icons.Default.Edit, "Crear perfil")
    object Perfil: NavDrawerItem( "verPerfil", Icons.Default.Person, "Ver perfiles")
}

