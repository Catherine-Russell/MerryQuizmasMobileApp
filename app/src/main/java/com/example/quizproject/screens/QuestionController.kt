package com.example.quizproject.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.quizproject.QuestionPage

@Composable
fun QuestionController(gainPoint: () -> Unit, quizCompleted: () -> Unit) {

    var currentQuestionNumber by remember {
        mutableIntStateOf(1)
    }

    var usedIndices by remember {
        mutableStateOf(mutableListOf<Int>())}
    val remainingIndices = (0 until 15).filterNot { usedIndices.contains(it)}

    fun newIndex (): Int {
        val randomNum = remainingIndices.random()
        usedIndices.add(randomNum)
        return randomNum
    }
    if (currentQuestionNumber <5) {
        QuestionPage(
            currentQuestionNumber = currentQuestionNumber,
            currentIndex = newIndex(),
            gainPoint,
            onNextClicked = {
                currentQuestionNumber += 1
                }
        )} else {
        QuestionPage(
            currentQuestionNumber = currentQuestionNumber,
            currentIndex = newIndex(),
            gainPoint,
            onNextClicked = {
                quizCompleted()
            })
        }
    }
