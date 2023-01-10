package com.example.ejemplo_21_11.screens

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.ejemplo_21_11.R
import com.example.ejemplo_21_11.database.ProfileEntity
import com.example.ejemplo_21_11.database.UserEntity
import com.example.ejemplo_21_11.model.UserViewModel
import com.example.ejemplo_21_11.ui.theme.Blue1

@Composable
fun ViewProfile(mUserViewModel: UserViewModel) {
    val profileList: List<ProfileEntity> by mUserViewModel.readAllDataProfile.observeAsState(listOf()) //tener lista actualizada //profile

    LazyColumn(
        modifier = Modifier.padding(10.dp)
    ) {
        items(profileList) { index ->
            ViewProfile(profileInfo = index, mUserViewModel)
        }
    }
}


@Composable
fun ViewProfile(profileInfo: ProfileEntity, mUserViewModel: UserViewModel) {
    Column(Modifier.padding(5.dp,10.dp)) {
            Image(
                modifier = Modifier
                    .size(80.dp)
                    .border(0.5.dp, Blue1, CircleShape)
                    .padding(1.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                painter = rememberAsyncImagePainter(
                    ImageRequest
                        .Builder(LocalContext.current)
                        .data(data = Uri.parse(profileInfo.profilePhoto))
                        .build()
                ),
                contentDescription = profileInfo.profileName,
            )
                Spacer(Modifier.size(15.dp))

                Text(
                    text = "Nombre:",
                    modifier = Modifier
                        .padding(8.dp, 0.dp),
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                )
                Text(
                    text = profileInfo.profileName,
                    modifier = Modifier
                        .padding(8.dp, 0.dp)
                )

                Spacer(Modifier.size(15.dp))

                Text(
                    text = "Pronombres:",
                    modifier = Modifier
                        .padding(8.dp, 0.dp),
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                )
                Text(
                    text = profileInfo.profilePronombres,
                    modifier = Modifier
                        .padding(8.dp, 0.dp)
                )

                Spacer(Modifier.size(15.dp))

                Text(
                    text = "Sobre mí:",
                    modifier = Modifier
                        .padding(8.dp, 0.dp),
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                )
                Text(
                    text = profileInfo.profileDescripcion,
                    modifier = Modifier
                        .padding(8.dp, 0.dp)
                )

                Spacer(Modifier.size(15.dp))

                Text(
                    text = "Orientación:",
                    modifier = Modifier
                        .padding(8.dp, 0.dp),
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                )
                Text(
                    text = profileInfo.profileOrientacion,
                    modifier = Modifier
                        .padding(8.dp, 0.dp)
                )

                Spacer(Modifier.size(15.dp))

                Text(
                    text = "Ubicación:",
                    modifier = Modifier
                        .padding(8.dp, 0.dp),
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                )
                Text(
                    text = profileInfo.profileUbicacion,
                    modifier = Modifier
                        .padding(8.dp, 0.dp)
                 )

                /*IconButton(onClick = { mUserViewModel.deleteUserProfile(profileInfo) })
                {Icon(imageVector = Icons.Default.Delete,
                    contentDescription = "Delete")}*/
       }
    }


