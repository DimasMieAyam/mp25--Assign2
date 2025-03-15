package com.example.mp25_assign2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inputText = findViewById<EditText>(R.id.inputText)
        val enterButton = findViewById<Button>(R.id.enterButton)
        val hiddenText = findViewById<TextView>(R.id.hiddenText)

        enterButton.setOnClickListener {
            val userInput = inputText.text.toString().trim()
            val number = userInput.toFloatOrNull()

            val piDigits = "3.14159265358979323846"
            val isPiPart = piDigits.startsWith(userInput)

            val message = when {
                userInput.isEmpty() -> "Kamu tidak memikirkan apa-apa"
                isPiPart && userInput.length > 3 -> "pi bernilai $piDigits"
                number == 69.toFloat() -> "Nice!"
                number != null && number in 0.0..99.0 -> "Kamu sedang memikirkan angka $userInput"
                userInput.lowercase() == "dimas" -> "Nama yang keren! \uD83D\uDE0E"
                else -> "Pikiranmu tidak bisa dibaca"
            }

            hiddenText.text = message
            hiddenText.visibility = View.VISIBLE
        }
    }
}