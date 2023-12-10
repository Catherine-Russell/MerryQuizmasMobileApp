package com.example.quizproject.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizproject.Header

@Composable
//@Preview(showBackground = true)
fun ScoreScreen (score: Int, startAgain: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier

    ) {
        Header()
        Text(text = "your score is...",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            lineHeight = 40.sp,
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "$score!",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 40.sp,
            fontFamily = FontFamily.Cursive,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = { startAgain() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Start again")
        }
    }
}