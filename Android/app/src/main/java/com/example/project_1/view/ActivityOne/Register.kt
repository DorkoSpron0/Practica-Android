package com.example.project_1.view.ActivityOne

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.project_1.view.ActivityOne.components.HeaderBibi

@SuppressLint("MutableCollectionMutableState")  /*explicacion mañana */
@Composable
fun Register(navController: NavController){

    var nombre by remember { mutableStateOf("") } // un texto de cadena que puede cambiar
    var email by remember { mutableStateOf("") } // un texto de cadena que puede cambiar
    var contraseña by remember { mutableStateOf("") } // un texto de cadena que puede cambiar


    Column(modifier = Modifier.fillMaxSize().padding(54.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly) {

            HeaderBibi()

            Text("Register", fontSize = 22.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)

            Column(
                verticalArrangement = Arrangement.Center,
            ) {
                TextField( // el textField es el cuadro del texto
                    modifier = Modifier.clip(RoundedCornerShape(10.dp)),
                    value = nombre, //el estado actual del elemento
                    onValueChange = {nombre = it},
                    label = {
                        Text(text = "Escribe tu nombre") // placehodler
                    },
                    placeholder = {
                        Text(text = "nicky")
                    }
                )
                Spacer(modifier = Modifier.height(40.dp))
                TextField( // el textField es el cuadro del texto
                    modifier = Modifier.clip(RoundedCornerShape(10.dp)),
                    value = email, //el estado actual del elemento
                    onValueChange = {email = it},
                    label = {
                        Text(text = "Escibre tu contraseña") // placehodler
                    },
                    placeholder = {
                        Text(text = "Password123")
                    }
                )
                Spacer(modifier = Modifier.height(40.dp))
                TextField( // el textField es el cuadro del texto
                    modifier = Modifier.clip(RoundedCornerShape(10.dp)),
                    value = contraseña, //el estado actual del elemento
                    onValueChange = {contraseña = it},
                    label = {
                        Text(text = "Escibre tu contraseña") // placehodler
                    },
                    placeholder = {
                        Text(text = "Password123")
                    }
                )
            }

            //Text(text = nombre, color = Color.Blue)

        Button(
            onClick = {navController.navigate("register")},
            modifier = Modifier.fillMaxWidth().height(50.dp),
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
                text = "Enviar",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

            Row(horizontalArrangement = Arrangement.Center) {
                Text("¿Ya tienes una cuenta? Inicia ")
                Text(
                    text = "Aquí",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable {
                        navController.navigate("login")
                        // Acción al hacer clic
                    }
                )
            }
        }

    }
