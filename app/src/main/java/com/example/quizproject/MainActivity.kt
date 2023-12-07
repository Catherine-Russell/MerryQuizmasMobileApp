package com.example.quizproject

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizproject.screens.Question1
import com.example.quizproject.screens.StartPage
import com.example.quizproject.ui.theme.QuizProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun App () {
    val background = painterResource(id = R.drawable.snowyscene)
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = background,
            contentDescription = null,
            contentScale = ContentScale.Crop,
//            alpha = 0.5F
            )

        val navController = rememberNavController()
        val startPageScreen = "START_PAGE"
        val question1Screen = "Q1"

        NavHost(navController = navController, startDestination = startPageScreen, builder = {

            composable(startPageScreen) {
                StartPage(quizInitiated = {
                    navController.navigate(question1Screen)
                })
            }

            composable(question1Screen) {
                Question1()
            }

        })

    }
}