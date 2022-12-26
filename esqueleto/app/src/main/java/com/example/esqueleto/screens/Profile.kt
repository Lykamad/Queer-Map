package com.example.esqueleto.screens

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.esqueleto.database.LocationsEntity
import com.example.esqueleto.model.UserViewModel

@Composable
fun ListUsers(mUserViewModel: UserViewModel) {
    val userList: List<LocationsEntity> by mUserViewModel.readAllData.observeAsState(listOf()) //tener lista actualizada //users??

    LazyColumn(
        modifier = Modifier.padding(10.dp)
    ) {
        items(userList) { index ->
            UserProfile(locationInfo = index, mUserViewModel)
        }
    }
}

@Composable
fun UserProfile(locationInfo: LocationsEntity, mUserViewModel: UserViewModel) {
    Column() {
        Row(
            Modifier.padding(8.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .size(80.dp)
                    .border(0.5.dp, Color.Blue, CircleShape)
                    .padding(1.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                painter = rememberAsyncImagePainter(
                    ImageRequest
                        .Builder(LocalContext.current)
                        .data(data = Uri.parse(locationInfo.placePhoto))
                        .build()
                ),
                contentDescription = locationInfo.placeName,
            )
            Spacer(Modifier.size(10.dp))
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
            ) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = locationInfo.placeName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    fontStyle = FontStyle.Italic,
                )
                Spacer(Modifier.size(8.dp))
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = locationInfo.placePhone
                )
            }
            Spacer(Modifier.size(10.dp))
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
            ) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = locationInfo.placeWeb,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    fontStyle = FontStyle.Italic,
                )
                Spacer(Modifier.size(8.dp))
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = locationInfo.placeAddress
                )
            }

            IconButton(onClick = { mUserViewModel.deleteUser(locationInfo) })
            {Icon(imageVector = Icons.Default.Delete,
                contentDescription = "Delete")}
        }

        Spacer(Modifier.size(8.dp))

    }
}

