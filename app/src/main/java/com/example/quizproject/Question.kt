package com.example.quizproject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.ImeAction

@Composable
fun Question (currentQuestionNumber:Int, currentQuestion: String, currentAnswer:String, correctResult:Boolean?, onValueChanged: (Boolean?) -> Unit) {

    var currentAnswerBoxInput by remember {
        mutableStateOf("")
    }
// Text field cannot be typed into once the answer has been submitted
    var textFieldEnabled by remember {
        mutableStateOf(true)
    }
    val submitEnabled: Boolean = currentAnswerBoxInput.isNotEmpty()
    fun submitAnswer() {
        onValueChanged(currentAnswerBoxInput.lowercase().trim() == currentAnswer.lowercase())
        textFieldEnabled = false
        currentAnswerBoxInput = ""
    }

    Column {
        Text(text = "Question $currentQuestionNumber", modifier = Modifier, fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = currentQuestion, fontSize = 20.sp, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = currentAnswerBoxInput,
            onValueChange = {
                currentAnswerBoxInput = it
            },

            placeholder = {
                Text(text = "Enter your answer")
            },
            enabled = textFieldEnabled,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {submitAnswer()})
        )
                    }
        if (correctResult == null) {
            Button(
                onClick = {
                          submitAnswer()
                },
                enabled = submitEnabled
            ) {
                val buttonText = if (submitEnabled) "Submit" else "Enter your answer"
                Text(buttonText)
            }
        }
        }