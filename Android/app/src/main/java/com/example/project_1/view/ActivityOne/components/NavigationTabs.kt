package com.example.project_1.view.ActivityOne.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NavigarionTabs(activeIndex: Int){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(3) { i ->
             Box(
                modifier = Modifier.width(12.dp)
                    .height(12.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(if(activeIndex==i) Color.Red else Color.Gray)

            ){}
            Spacer(modifier = Modifier.width(5.dp))
        }
    }
}