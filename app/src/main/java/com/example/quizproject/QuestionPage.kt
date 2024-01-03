package com.example.quizproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun QuestionPage(
    currentQuestionNumber: Int,
    currentIndex: Int,
    gainPoint: () -> Unit,
    onNextClicked: () -> Unit) {


    val currentQuestion = getRandomQuestion(currentIndex)
    val currentAnswer = getRandomAnswer(currentIndex)
    val currentHint = getRandomHint(currentIndex)
    // Text field cannot be typed into once the answer has been submitted
    var textFieldEnabled by remember {
        mutableStateOf(true)
    }

    var correctResult: Boolean? by remember {
        mutableStateOf(null)
    }

    val modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)
        .offset(0.dp, (-40).dp)

    Column (modifier = modifier, verticalArrangement = Arrangement.Center) {
        Header()
        Spacer(modifier = Modifier.height(20.dp))
        Question(currentQuestionNumber, currentQuestion, currentAnswer, correctResult, textFieldEnabled, disableTextField = {textFieldEnabled = false}, onValueChanged = {
            correctResult = it
        })
        Spacer(modifier = Modifier.height(20.dp))
        Answer(correctResult, currentAnswer)
        NextButton(correctResult, currentQuestionNumber, onNext2 = {
            if (correctResult == true) { gainPoint() }
            correctResult = null
            textFieldEnabled = true
            onNextClicked()
        })
        Hint(currentHint)
        }
    }


@Composable
fun getRandomQuestion(index: Int): String {
    val questions = arrayOf(R.string.Q1, R.string.Q2, R.string.Q3, R.string.Q4, R.string.Q5, R.string.Q6,R.string.Q7, R.string.Q8, R.string.Q9,R.string.Q10, R.string.Q11, R.string.Q12, R.string.Q13, R.string.Q14, R.string.Q15)
    return stringResource(id = questions[index])
}
@Composable
fun getRandomAnswer(index: Int): String {
    val answers = arrayOf(R.string.A1, R.string.A2, R.string.A3, R.string.A4, R.string.A5, R.string.A6, R.string.A7, R.string.A8, R.string.A9, R.string.A10, R.string.A11, R.string.A12, R.string.A13, R.string.A14, R.string.A15)
    return stringResource(id = answers[index])
}

@Composable
fun getRandomHint(index: Int): String {
    val hints = arrayOf(R.string.H1, R.string.H2, R.string.H3, R.string.H4, R.string.H5, R.string.H6, R.string.H7, R.string.H8, R.string.H9, R.string.H10, R.string.H11, R.string.H12, R.string.H13, R.string.H14, R.string.H15)
    return stringResource(id = hints[index])
}