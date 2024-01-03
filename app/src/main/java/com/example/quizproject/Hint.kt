package com.example.quizproject

import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun Hint(hint:String, hintUsed: () -> Unit) {
    val context = LocalContext.current
    val hintToast = Toast.makeText(context, hint, Toast.LENGTH_LONG)
    fun hintPopUp () {
        hintToast.show()
    }
    Button(
        onClick = {
            hintPopUp()
            hintUsed()
        },
        enabled = true,
    )  {
        Text(text = "Hint")
    }
}
