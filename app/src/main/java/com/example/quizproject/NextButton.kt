package com.example.quizproject

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun NextButton(correctResult: Boolean?, onNext2: () -> Unit) {
    if (correctResult != null) {
        Button(
            onClick = {
                onNext2() }, //{ nextPageClicked() },
            enabled = true
        ) {
            Text(text = "Next")
        }
    } else {}
}
