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

//view.findViewById<Button>(R.id.toast_button).setOnClickListener {
//    // create a Toast with some text, to appear for a short time
//    val myToast = Toast.makeText(context,
//        getString(R.string.toast_pop_up), Toast.LENGTH_SHORT)
//    // show the Toast
//    myToast.show()
//}