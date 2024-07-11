package com.example.myapplication

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNumber1 = findViewById<EditText>(R.id.etNumber1)
        val etNumber2 = findViewById<EditText>(R.id.etNumber2)
        val spinnerOperations = findViewById<Spinner>(R.id.spinnerOperations)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Populate the spinner with operation options
        val operations = arrayOf("Add", "Subtract", "Multiply", "Divide")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, operations)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOperations.adapter = adapter

        // Set the onClickListener for the Calculate button
        btnCalculate.setOnClickListener {
            val number1 = etNumber1.text.toString().toDoubleOrNull()
            val number2 = etNumber2.text.toString().toDoubleOrNull()
            val selectedOperation = spinnerOperations.selectedItem.toString()

            if (number1 != null && number2 != null) {
                val result = when (selectedOperation) {
                    "Add" -> number1 + number2
                    "Subtract" -> number1 - number2
                    "Multiply" -> number1 * number2
                    "Divide" -> {
                        if (number2 != 0.0) {
                            number1 / number2
                        } else {
                            Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                            return@setOnClickListener
                        }
                    }
                    else -> 0.0
                }
                tvResult.text = "Result: $result"
            } else {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }
    }
}



























