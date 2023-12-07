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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizproject.Header

@Composable
//@Preview(showBackground = true)
fun StartPage (quizInitiated: () -> Unit ) {
    Column (
        modifier = Modifier,
        verticalArrangement= Arrangement.SpaceEvenly,
    ) {
        Header()
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Welcome to the Merry Quizmas Quiz")
        Button(
            onClick = { quizInitiated() },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Text(
                text = "Start!"
            )
        }
    }
}