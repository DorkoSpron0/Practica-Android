package com.example.project_1.view.ActivityOne

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.project_1.R
import com.example.project_1.view.ActivityOne.components.HeaderBibi
import com.example.project_1.view.ActivityOne.components.NavigarionTabs

@Composable
fun ThirdPage(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        HeaderBibi()

        Image(modifier = Modifier.width(300.dp).height(300.dp),
            painter = painterResource(id = R.drawable.plane),
            contentDescription = "Description")

        Text(
            text = "Get Started!",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 60.dp)
        )

        NavigarionTabs(2)

        Button(
            onClick = {navController.navigate("register")},
            modifier = Modifier.fillMaxWidth().height(50.dp).padding(horizontal = 40.dp),
            colors = ButtonColors(
                contentColor = Color.White, // -> No afecta en nada
                containerColor = Color.Transparent,
                disabledContentColor = Color.Gray,
                disabledContainerColor = Color.Gray
            ),
            border = BorderStroke(
                width = 1.dp,
                color = Color.Red
            )
        ) {
            Text(
                text = "Registration",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Already have an account? ",
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
            )
            Text(
                text = " Login",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier.clickable {
                    navController.navigate("login")
                }
            )
        }

    }
}