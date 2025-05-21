package com.example.project_1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.project_1.ui.theme.Project_1Theme
import com.example.project_1.view.ActivityOne.FirstPage
import com.example.project_1.view.ActivityOne.Navigation
import com.example.project_1.view.ActivityOne.SecondPage
import com.example.project_1.view.ActivityOne.ThirdPage
import com.example.project_1.view.ActivityTwo.MyNavigation

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project_1Theme {
                Scaffold {
                    //HorizontalPages()
                    //MyNavigation()
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun HorizontalPages(navController: NavController){
    val pageState = rememberPagerState(pageCount = {3})

    HorizontalPager(state = pageState) { page ->
        when(page){
            0 -> FirstPage()
            1 -> SecondPage()
            2 -> ThirdPage(navController)
            else -> Text(text = "No se encontró")
        }
    }
}

