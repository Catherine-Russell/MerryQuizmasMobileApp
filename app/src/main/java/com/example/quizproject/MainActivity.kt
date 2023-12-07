package com.example.quizproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    AppScreen()
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AppScreen () {
    var correctAnswer: Boolean? by remember {
        mutableStateOf(null)
    }

    val modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)
        .offset(0.dp, (-40).dp)

    Column (modifier = modifier, verticalArrangement = Arrangement.Center) {
        Header()
        Spacer(modifier = Modifier.height(20.dp))
        Question(correctAnswer, onValueChanged = {
            correctAnswer = it)
        Spacer(modifier = Modifier.height(20.dp))
        Answer(correctAnswer)
        })
        NextButton()
    }
}