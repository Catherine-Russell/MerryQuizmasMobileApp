package com.example.quizproject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun Question (correctAnswer:Boolean?, onValueChanged: (Boolean?) -> Unit) {

    var currentAnswerBoxInput by remember {
        mutableStateOf("")
    }
    val submitEnabled: Boolean = currentAnswerBoxInput.isNotEmpty()

    Column {
        Text(text = "Question 1", modifier = Modifier, fontSize = 30.sp)
        Text(text = "What star sign was baby Jesus?")

        TextField(
            value = currentAnswerBoxInput,
            onValueChange = {
                currentAnswerBoxInput = it
            },
            placeholder = {
                Text(text = "Enter your answer")
            },
            modifier = Modifier.fillMaxWidth()
        )
        if (correctAnswer == null) {
            Button(
                onClick = {
                    onValueChanged(currentAnswerBoxInput.lowercase() == "capricorn")
                },
                enabled = submitEnabled
            ) {
                val buttonText = if (submitEnabled) "Submit" else "Enter your answer"
                Text(buttonText)
            }
        }
        }
}
