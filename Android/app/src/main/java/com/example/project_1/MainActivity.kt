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
import com.example.project_1.view.ActivityThree.Contador
import com.example.project_1.view.ActivityThree.EmailIcon
import com.example.project_1.view.ActivityThree.EmailValidator
import com.example.project_1.view.ActivityThree.IndicatorPassword
import com.example.project_1.view.ActivityThree.LimitText
import com.example.project_1.view.ActivityThree.TaskList
import com.example.project_1.view.ActivityThree.ThemeChanger
import com.example.project_1.view.ActivityThree.ValidateForm
import com.example.project_1.view.ActivityThree.ValidateNumber
import com.example.project_1.view.ActivityTwo.MyNavigation
import com.example.project_1.view.transitions.Formulario
import com.example.project_1.view.transitions.MyNavigationTransitions
import com.example.project_1.view.transitions.TemaDinamico
import com.example.project_1.viewmodel.ActivityThree.CargaSimulada
import com.example.project_1.viewmodel.ActivityThree.ContadorViewModel

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
                    //Navigation()
                    //MyNavigationTransitions()
                    //Formulario()
                    //TemaDinamico()

                    // ACTIVIDAD TRES

                    //Contador()
                    //EmailValidator()
                    //ValidateNumber()
                    //ThemeChanger()
                    //IndicatorPassword()
                    //ValidateForm()
                    //TaskList()
                    //LimitText()
                    //EmailIcon()
                    CargaSimulada()
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

