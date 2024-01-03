package com.example.quizproject

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
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
    private lateinit var btnToggleMusic : Button
    var mediaPlayer : MediaPlayer? = null
    private var isMusicPlaying: Boolean by mutableStateOf(false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mediaPlayer = MediaPlayer.create(this, R.raw.backgroundmusic)

        setContent {
            QuizProjectTheme {
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
fun App() {

    val background = painterResource(id = R.drawable.snowyscene)
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = background,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        val navController = rememberNavController()
        val startPageScreen = "START_PAGE"
        val questionScreen = "Question"
        val scoreScreen = "SCORE"

        var score: Int by remember {
            mutableIntStateOf(0)
        }
        var hintCount: Int by remember {
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
                    gainPoint = { score += 1 },
                    hintUsed = { hintCount += 1 },
                    quizCompleted = { navController.navigate(scoreScreen) }
                )
            }

            composable(scoreScreen) {
                ScoreScreen(score, hintCount, startAgain = {
                    navController.navigate(startPageScreen)
                    score = 0
                })
            }
        })
    }
}
