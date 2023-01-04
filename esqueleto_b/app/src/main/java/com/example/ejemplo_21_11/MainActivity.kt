
package com.example.ejemplo_21_11

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.ejemplo_21_11.components.BottomBar
import com.example.ejemplo_21_11.components.Drawer
import com.example.ejemplo_21_11.components.TopBar
import com.example.ejemplo_21_11.navigation.Navegacion
import com.example.ejemplo_21_11.model.UserViewModel
import com.example.ejemplo_21_11.model.UserViewModelFactory
import com.example.ejemplo_21_11.ui.theme.Ejemplo_21_11Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejemplo_21_11Theme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val context = LocalContext.current
                    val mUserViewModel: UserViewModel = viewModel(
                    factory = UserViewModelFactory(context.applicationContext as Application)
                    )
                    MainScreen(userViewModel = mUserViewModel)
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(userViewModel: UserViewModel) {
    var navController = rememberNavController()

    var scaffoldState = rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    var scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope, scaffoldState) },
        bottomBar = { BottomBar(navController) },
        drawerContent = { Drawer(scope, scaffoldState, navController = navController)},
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("crearUsuarios") },
                backgroundColor = Color.Blue,
                contentColor = Color.White
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "fabicon"
                )
            }
        }
    ){
        Navegacion(navController = navController, userViewModel = userViewModel)
    }
}

