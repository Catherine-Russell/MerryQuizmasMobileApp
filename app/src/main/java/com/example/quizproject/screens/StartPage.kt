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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizproject.Header

@Composable
fun StartPage (quizInitiated: () -> Unit ) {
    Column (
        modifier = Modifier,
        verticalArrangement= Arrangement.SpaceEvenly,
    ) {
        Header()
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Test your christmassy knowledge on our exciting Christmas Quiz!",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 40.sp,
            fontFamily = FontFamily.Cursive,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(50.dp))

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

@Composable
@Preview(showBackground = true)
fun PreviewTextbox() {
    Text(text = "Are you ready to test your christmassy knowledge on our exciting Christmas Quiz?",
        color = Color.Red,
        fontSize = 40.sp,
        fontFamily = FontFamily.Cursive,
        fontStyle = FontStyle.Italic,
        lineHeight = 50.sp,
        textAlign = TextAlign.Center

    )
}
