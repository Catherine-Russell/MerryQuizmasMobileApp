package com.example.quizproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Composable
fun Header() {
    Column {
        val imageModifier = Modifier.fillMaxWidth()
//        val title = textValue
        Image(
            painter = painterResource(id = R.drawable.quiztime),
            contentDescription = "quiz logo",
            modifier = imageModifier
        )
        Spacer(modifier = Modifier.height(20.dp)
        )
    }
}
