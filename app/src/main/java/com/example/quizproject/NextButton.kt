package com.example.quizproject

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.w3c.dom.Text

@Composable
fun NextButton(correctResult: Boolean?, currentQuestionNumber: Int, onNext2: () -> Unit) {
    if (correctResult != null) {
        Button(
            onClick = {
                onNext2()
            },
            enabled = true
        ) {
            var buttonText: String
            if (currentQuestionNumber < 5) {
                buttonText = "Next"
            } else {
                buttonText = "Get Score"
            }
//            val buttonText: String = "current = $currentQuestionNumber" //= if (currentQuestionNumber == 5) "Next" else "Finish Quiz"
            Text(text = buttonText)
        }
    }
}

