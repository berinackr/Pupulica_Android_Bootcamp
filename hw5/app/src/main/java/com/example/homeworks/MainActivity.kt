package com.example.homeworks
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworks.R

class MainActivity : AppCompatActivity() {

    private lateinit var textResult: TextView
    private lateinit var textExpression: TextView

    private var firstNumber = ""
    private var secondNumber = ""
    private var isPlusPressed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textResult = findViewById(R.id.textResult)
        textExpression = findViewById(R.id.textExpression)

        val numberButtons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        for (id in numberButtons) {
            findViewById<Button>(id).setOnClickListener {
                val digit = (it as Button).text.toString()
                if (!isPlusPressed) {
                    firstNumber += digit
                    textResult.text = firstNumber
                } else {
                    secondNumber += digit
                    textResult.text = secondNumber
                }
            }
        }

        findViewById<Button>(R.id.btnPlus).setOnClickListener {
            if (firstNumber.isNotEmpty()) {
                isPlusPressed = true
                textExpression.text = "$firstNumber +"
                textResult.text = "0"
            }
        }

        findViewById<Button>(R.id.btnEqual).setOnClickListener {
            if (firstNumber.isNotEmpty() && secondNumber.isNotEmpty()) {
                val result = firstNumber.toInt() + secondNumber.toInt()
                textExpression.text = "$firstNumber + $secondNumber ="
                textResult.text = result.toString()

                // Reset for next operation
                firstNumber = result.toString()
                secondNumber = ""
                isPlusPressed = false
            }
        }

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            firstNumber = ""
            secondNumber = ""
            isPlusPressed = false
            textResult.text = "0"
            textExpression.text = ""
        }
    }
}
