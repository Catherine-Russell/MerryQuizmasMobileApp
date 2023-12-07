package com.example.quizproject

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun NextButton() {
    Button(
        onClick = {},
        enabled = false
    ) {
        Text(text = "Next")
    }
}
