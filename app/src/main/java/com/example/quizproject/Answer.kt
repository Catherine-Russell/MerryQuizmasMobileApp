package com.example.quizproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.stringResource

@Composable
fun Answer(correctAnswer: Boolean?) {
    when (correctAnswer) {
        true -> Column {
            StyledImage(R.drawable.smart, "Correct Answer")
            Text(stringResource(R.string.correct_answer))
        }
        false -> Column {
            StyledImage(R.drawable.stupid, "Incorrect Answer")
            Text(stringResource(R.string.incorrect_answer))
        }
        null -> { /* Do nothing or display nothing */ }
    }
}

@Composable
fun StyledImage(imageRes: Int, contentDescription: String) {
    Box(modifier = Modifier.padding(16.dp)) {
        Surface(
            modifier = Modifier
                .shadow(4.dp, RoundedCornerShape(4.dp))
                .border(2.dp, Color.Black, RoundedCornerShape(4.dp))
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = contentDescription
            )
        }
    }
}
//
//@Preview
//@Composable
//fun PreviewCorrectFeedback() {
//    val correctAnswer = remember { mutableStateOf<Boolean?>(true) }
//    Answer(correctAnswer = true)
//}







@Preview
@Composable
fun PreviewCorrectFeedback() {
    val correctAnswer = remember { mutableStateOf<Boolean?>(true) }

    // Wrap your preview in a Surface with a contrasting background
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.padding(16.dp)) {
            Answer(correctAnswer = correctAnswer.value)
        }
    }
}