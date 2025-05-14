package com.example.project_1.view.ActivityOne.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderBibi(){
    Row( // -> Logo Bibi
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "©",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Bottom).padding(bottom = 5.dp)
        )
        Text(
            text = "bibi",
            fontSize = 44.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Bottom)
        )
    }
}