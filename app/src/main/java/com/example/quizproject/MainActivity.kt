package com.example.quizproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizproject.screens.QuestionController
import com.example.quizproject.screens.ScoreScreen
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
        val questionScreen = "Question"
        val scoreScreen = "SCORE"

        var score: Int by remember {
            mutableIntStateOf(0)
        }

        NavHost(navController = navController, startDestination = startPageScreen, builder = {


            composable(startPageScreen) {
                StartPage(quizInitiated = {
                    navController.navigate(questionScreen)
                })
            }

            composable(questionScreen) {
                QuestionController(
                    gainPoint = { score +=1 },
                    quizCompleted = { navController.navigate(scoreScreen) }
                )
            }

            composable(scoreScreen) {
                ScoreScreen(score, startAgain = {
                    score = 0
                    navController.navigate(startPageScreen)
                })
            }
        })
    }
}
