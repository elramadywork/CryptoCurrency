package com.example.cryptocurrencyapp.presentation.coin_detail.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.cryptocurrencyapp.data.remote.dto.TeamMembers

@SuppressLint("UnrememberedMutableState")
@Composable
fun TeamListItem(
    teamMembers: TeamMembers,
    modifier: Modifier=Modifier,
){
 Column(
     modifier=modifier,
     verticalArrangement = Arrangement.Center,

 ) {

     Text(
         text =teamMembers.name,
         style = MaterialTheme.typography.headlineSmall
     )
     Spacer(modifier = Modifier.height(4.dp))

     Text(
         text =teamMembers.position,
         style = MaterialTheme.typography.headlineMedium,
         fontStyle = FontStyle.Italic
     )
 }
}