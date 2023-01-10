package com.example.ejemplo_21_11.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemplo_21_11.database.UserEntity
import com.example.ejemplo_21_11.model.UserViewModel

@Composable
fun ListUsers(mUserViewModel: UserViewModel) {
    val userList: List<UserEntity> by mUserViewModel.readAllData.observeAsState(listOf()) //tener lista actualizada //users??

    LazyColumn(
        modifier = Modifier.padding(10.dp)
    ) {
        items(userList) { index ->
            UserProfile(userInfo = index, mUserViewModel)
        }
    }
}

@Composable
fun UserProfile(userInfo: UserEntity, mUserViewModel: UserViewModel) {
    Column() {
        Row(
            Modifier.padding(8.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {

            Spacer(Modifier.size(10.dp))
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
            ) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = userInfo.cUserName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                )
                Spacer(Modifier.size(8.dp))
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = userInfo.cUserPhone
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
                    text = userInfo.cUserEmail,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    fontStyle = FontStyle.Italic,
                )
                Spacer(Modifier.size(8.dp))
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = userInfo.cUserCity
                )
            }

            IconButton(onClick = { mUserViewModel.deleteUser(userInfo) })
            {Icon(imageVector = Icons.Default.Delete,
                contentDescription = "Delete")}
        }




    }
}

