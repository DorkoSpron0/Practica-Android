package com.example.project_1.view.ActivityOne

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_1.R
import com.example.project_1.view.ActivityOne.components.HeaderBibi
import com.example.project_1.view.ActivityOne.components.NavigarionTabs

@Composable
fun FirstPage(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        HeaderBibi()

        Image(modifier = Modifier.width(300.dp).height(300.dp),
            painter = painterResource(id = R.drawable.undraw_professional_woman_avatar_ivds),
            contentDescription = "Description")

        Text(
            text = "For students who want to become flight attendants",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 50.dp)
        )

        Text(text = "Communicate with flight attendants,\n" +
                "meet, find out useful information\n" +
                " that will help you fulfill your dream",

            fontSize = 16.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 40.dp)
            )

        NavigarionTabs(1)
    }
}