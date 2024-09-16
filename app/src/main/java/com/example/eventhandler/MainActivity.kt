package com.example.eventhandler

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var display: EditText
    private var pilihanOperasi = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        val btn0: Button = findViewById(R.id.btn0)
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btn4: Button = findViewById(R.id.btn4)
        val btn5: Button = findViewById(R.id.btn5)
        val btn6: Button = findViewById(R.id.btn6)
        val btn7: Button = findViewById(R.id.btn7)
        val btn8: Button = findViewById(R.id.btn8)
        val btn9: Button = findViewById(R.id.btn9)
        val btnAdd: Button = findViewById(R.id.btnAdd)
        val btnSubtract: Button = findViewById(R.id.btnSubtract)
        val btnMultiply: Button = findViewById(R.id.btnMultiply)
        val btnDivide: Button = findViewById(R.id.btnDivide)
        val btnEqual: Button = findViewById(R.id.btnEqual)
        val btnClear: Button = findViewById(R.id.btnClear)

        btn0.setOnClickListener { tambahkanKeOperasi("0") }
        btn1.setOnClickListener { tambahkanKeOperasi("1") }
        btn2.setOnClickListener { tambahkanKeOperasi("2") }
        btn3.setOnClickListener { tambahkanKeOperasi("3") }
        btn4.setOnClickListener { tambahkanKeOperasi("4") }
        btn5.setOnClickListener { tambahkanKeOperasi("5") }
        btn6.setOnClickListener { tambahkanKeOperasi("6") }
        btn7.setOnClickListener { tambahkanKeOperasi("7") }
        btn8.setOnClickListener { tambahkanKeOperasi("8") }
        btn9.setOnClickListener { tambahkanKeOperasi("9") }

        btnAdd.setOnClickListener { tambahkanKeOperasi("+") }
        btnSubtract.setOnClickListener { tambahkanKeOperasi("-") }
        btnMultiply.setOnClickListener { tambahkanKeOperasi("*") }
        btnDivide.setOnClickListener { tambahkanKeOperasi("/") }
        btnClear.setOnClickListener {
            pilihanOperasi = ""
            display.setText(pilihanOperasi)
        }

        btnEqual.setOnClickListener {
            val tokens = pilihanOperasi.split("+", "-", "*", "/")
            val result = if (tokens.size == 2) {
                val num1 = tokens[0].toDoubleOrNull()
                val num2 = tokens[1].toDoubleOrNull()
                when {
                    num1 == null || num2 == null -> "Invalid Numbers"
                    pilihanOperasi.contains("+") -> (num1 + num2).toString()
                    pilihanOperasi.contains("-") -> (num1 - num2).toString()
                    pilihanOperasi.contains("*") -> (num1 * num2).toString()
                    pilihanOperasi.contains("/") -> if (num2 != 0.0) (num1 / num2).toString() else "Error: Bagi dengan 0"
                    else -> "Error"
                }
            } else {
                "Invalid"
            }
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("RESULT", result)
            startActivity(intent)
        }
    }

    private fun tambahkanKeOperasi(value: String) {
        pilihanOperasi += value
        display.setText(pilihanOperasi)
    }

    override fun onResume() {
        super.onResume()
        pilihanOperasi = ""
        display.setText(pilihanOperasi)
    }
}
