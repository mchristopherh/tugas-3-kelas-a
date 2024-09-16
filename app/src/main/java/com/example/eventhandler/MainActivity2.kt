package com.example.eventhandler

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val result = intent.getStringExtra("RESULT") ?: "No Result"

        val resultTextView: TextView = findViewById(R.id.hasil)
        resultTextView.text = "Hasil: $result"

        val btnBack: Button = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
    }
}
