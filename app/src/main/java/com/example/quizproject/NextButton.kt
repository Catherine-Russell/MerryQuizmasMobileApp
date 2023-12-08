package com.example.quizproject

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun NextButton(correctAnswer: Boolean?) {
    if (correctAnswer != null) {
        Button(
            onClick = {}, //{ nextPageClicked() },
            enabled = true
        ) {
            Text(text = "Next")
        }
    } else {}
}
