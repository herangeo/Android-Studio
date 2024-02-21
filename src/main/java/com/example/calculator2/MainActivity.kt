package com.example.calculator2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val BmiButton: Button = findViewById(R.id.button2)
        val MulButton: Button = findViewById(R.id.button14)
        val DivButton: Button = findViewById(R.id.button12)
        val AddButton: Button = findViewById(R.id.button13)
        val DiffButton: Button = findViewById(R.id.button6)

        val WeightText: EditText = findViewById(R.id.editTextText3)
        val HeightText: EditText = findViewById(R.id.editTextText4)
        val DisplayBmi: EditText = findViewById(R.id.editTextText5)
        val FirstInput: EditText = findViewById(R.id.editTextText6)
        val SecondInput: EditText = findViewById(R.id.editTextText)
        val Output: EditText = findViewById(R.id.editTextText7)

        BmiButton.setOnClickListener {

            val weightInput: String = WeightText.text.toString()
            val heightInput: String = HeightText.text.toString()

            if (weightInput.isEmpty() || heightInput.isEmpty()) {
                Toast.makeText(this, "Please enter both weight and height", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val weight: Double = weightInput.toDouble()
                val height: Double = heightInput.toDouble()

                if (weight <= 0 || height <= 0) {
                    Toast.makeText(this, "Weight and height must be greater than zero", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val bmi: Double = weight / (height * height)
                val bmiMessage: String = "$bmi"
                DisplayBmi.setText(bmiMessage)

                if (bmi < 18.5) {
                    Toast.makeText(this, "You are considered underweight and possibly malnourished", Toast.LENGTH_SHORT).show()
                } else if (bmi >= 18.5 && bmi <= 24.9) {
                    Toast.makeText(this, "You are within a healthy weight range for young and middle-aged adults.", Toast.LENGTH_SHORT).show()
                } else if (bmi >= 25.0 && bmi <= 29.9) {
                    Toast.makeText(this, "You are considered overweight", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "You are considered obese", Toast.LENGTH_SHORT).show()
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Invalid input. Please enter valid numbers for weight and height", Toast.LENGTH_SHORT).show()
            }
        }

        MulButton.setOnClickListener {
            try {
                val firstValue: Double = FirstInput.text.toString().toDouble()
                val secondValue: Double = SecondInput.text.toString().toDouble()

                val outputValue: Double = firstValue * secondValue
                val outputString: String = "$outputValue"
                Output.setText(outputString)
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Invalid input. Please enter valid numbers for multiplication", Toast.LENGTH_SHORT).show()
            }
        }

        DivButton.setOnClickListener {
            try {
                val firstValue: Double = FirstInput.text.toString().toDouble()
                val secondValue: Double = SecondInput.text.toString().toDouble()

                if (secondValue == 0.0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val outputValue: Double = firstValue / secondValue
                val outputString: String = "$outputValue"
                Output.setText(outputString)
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Invalid input. Please enter valid numbers for division", Toast.LENGTH_SHORT).show()
            }
        }

        AddButton.setOnClickListener {
            try {
                val firstValue: Double = FirstInput.text.toString().toDouble()
                val secondValue: Double = SecondInput.text.toString().toDouble()

                val outputValue: Double = firstValue + secondValue
                val outputString: String = "$outputValue"
                Output.setText(outputString)
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Invalid input. Please enter valid numbers for addition", Toast.LENGTH_SHORT).show()
            }
        }

        DiffButton.setOnClickListener {
            try {
                val firstValue: Double = FirstInput.text.toString().toDouble()
                val secondValue: Double = SecondInput.text.toString().toDouble()

                val outputValue: Double = firstValue - secondValue
                val outputString: String = "$outputValue"
                Output.setText(outputString)
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Invalid input. Please enter valid numbers for subtraction", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
