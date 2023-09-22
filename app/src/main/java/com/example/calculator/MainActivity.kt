package com.example.calculator

import android.media.tv.TvView
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.notkamui.keval.Keval


class MainActivity : AppCompatActivity() {

    val actions = listOf("*", "+", "/", "-")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


     fun onClick(view: View?) {
        val button = view as? Button
        button ?: return

        val textView = findViewById<TextView>(R.id.MainView)
        val buttonValue = button.text.toString()
        when {
            buttonValue.first().isDigit() -> {
                textView.text = textView.text.toString().plus(buttonValue)
            }
            button.id == R.id.clear -> {
                textView.text = ""
            }
            actions.contains(buttonValue) -> {
                if(textView.text.toString() !="" && textView.text.toString().last().isDigit())
                    textView.text = textView.text.toString().plus(buttonValue)
            }
            button.id == R.id.enter -> {
                textView.text = Keval.eval(textView.text.toString()).toString()
            }
            buttonValue == "." -> {
                if(textView.text.toString() !="" && textView.text.toString().last().isDigit())
                    textView.text = textView.text.toString().plus(buttonValue)
            }
        }
    }
}