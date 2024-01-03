package com.example.quizproject.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizproject.Header

@Composable
fun ScoreScreen (score: Int, hintCount:Int, startAgain: () -> Unit) {
    val message = if (score >= 3) "Congratulations! Your score is" else "Better luck next time! Your score was"
    val hintMessage = if (hintCount == 1) "You used $hintCount hint" else "You used $hintCount hints"
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()

    ) {
        Header()
        Column (
            modifier = Modifier
//                .fillMaxSize()
                .padding(16.dp)
        ){
            Text(text = message,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                lineHeight = 40.sp,
                textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "$score out of 5!",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 50.sp,
                fontFamily = FontFamily.Cursive,
                lineHeight = 50.sp,
                textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = hintMessage,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                lineHeight = 50.sp,
                textAlign = TextAlign.Center)
        }
        Button(
            onClick = { startAgain() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp) // Adjust the padding as needed
                .align(Alignment.End)
        ) {
            Text(text = "Start again")
        }
    }
}