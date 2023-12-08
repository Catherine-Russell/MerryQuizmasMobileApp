package com.example.quizproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Answer(correctResult: Boolean?, currentAnswer: String) {
    when (correctResult) {
        true -> Column {
            val imageModifier = Modifier.fillMaxWidth()
                .size(100.dp) // Adjust the size as needed
            Text(currentAnswer +"!\n"+ stringResource(R.string.correct_answer),
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,)
            Image(
                painter = painterResource(id = R.drawable.smart),
                "Correct Answer",
                modifier = imageModifier)


        }
        false -> Column {
            val imageModifier = Modifier.fillMaxWidth()
                .size(100.dp) // Adjust the size as needed

            Text(stringResource(R.string.incorrect_answer) + currentAnswer,
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,)
            Image(
                painter = painterResource(id = R.drawable.stupid),
                "Incorrect Answer",
                modifier = imageModifier)
        }
        null -> { /* Do nothing or display nothing */ }
    }
}

//@Composable
//fun StyledImage(imageRes: Int, contentDescription: String) {
//    Modifier.fillMaxWidth()
//    Box(modifier = Modifier.padding(16.dp)) {
//        Surface(
//            modifier = Modifier
//                .shadow(4.dp, RoundedCornerShape(4.dp))
//                .border(2.dp, Color.Black, RoundedCornerShape(4.dp))
//                .padding(8.dp)
//        ) {
//            Image(
//                painter = painterResource(id = imageRes),
//                contentDescription = contentDescription
//            )
//        }
//    }
//}
//
//@Preview
//@Composable
//fun PreviewCorrectFeedback() {
//    val correctAnswer = remember { mutableStateOf<Boolean?>(true) }
//    Answer(correctAnswer = true)
//}

