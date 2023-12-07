package com.example.quizproject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

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
