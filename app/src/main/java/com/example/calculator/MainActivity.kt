package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var numberView : TextView

    // Buttons for 0-9
    // TODO: Too many button variables. Obviously this is not the best way.
    //       We can define a class (NumberButton), and dynamically create any buttons
    //       with their onClickListeners attached.
    lateinit var button0 : Button
    lateinit var button1 : Button
    lateinit var button2 : Button
    lateinit var button3 : Button
    lateinit var button4 : Button
    lateinit var button5 : Button
    lateinit var button6 : Button
    lateinit var button7 : Button
    lateinit var button8 : Button
    lateinit var button9 : Button

    lateinit var buttonAdd : Button
    lateinit var buttonSubtract : Button
    lateinit var buttonMultiply : Button
    lateinit var buttonDivide : Button

    lateinit var buttonCalculate : Button

    lateinit var buttonClear : Button

    // TODO: Implement these functionalities
    // lateinit var buttonPlusMinus : Button
    // lateinit var buttonPoint : Button

    var currentAnswer : Long = 0
    var currentOperation : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setOnClickListenersOnNumberButtons()
        setOnClickListenersOnOperationButtons()
        setOnClickListenersOnOtherButtons()
    }

    private fun initViews() {
        numberView = findViewById(R.id.number_view)

        button0 = findViewById(R.id.btn_0)
        button1 = findViewById(R.id.btn_1)
        button2 = findViewById(R.id.btn_2)
        button3 = findViewById(R.id.btn_3)
        button4 = findViewById(R.id.btn_4)
        button5 = findViewById(R.id.btn_5)
        button6 = findViewById(R.id.btn_6)
        button7 = findViewById(R.id.btn_7)
        button8 = findViewById(R.id.btn_8)
        button9 = findViewById(R.id.btn_9)

        buttonAdd = findViewById(R.id.btn_add)
        buttonSubtract = findViewById(R.id.btn_subtract)
        buttonMultiply = findViewById(R.id.btn_multiply)
        buttonDivide = findViewById(R.id.btn_divide)

        buttonCalculate = findViewById(R.id.btn_calculate)

        buttonClear = findViewById(R.id.btn_clear)
    }

    private fun setOnClickListenersOnNumberButtons() {
        button0.setOnClickListener { writeDigit(0) }
        button1.setOnClickListener { writeDigit(1) }
        button2.setOnClickListener { writeDigit(2) }
        button3.setOnClickListener { writeDigit(3) }
        button4.setOnClickListener { writeDigit(4) }
        button5.setOnClickListener { writeDigit(5) }
        button6.setOnClickListener { writeDigit(6) }
        button7.setOnClickListener { writeDigit(7) }
        button8.setOnClickListener { writeDigit(8) }
        button9.setOnClickListener { writeDigit(9) }
    }

    @SuppressLint("SetTextI18n")
    private fun writeDigit(digit: Long) {
        var currentNumber : String = numberView.text.toString()
        if (digit == 0L && currentNumber.equals("0")) {
            // TODO: Handle the point input
            return;
        }
        numberView.text = currentNumber + digit
    }

    private fun setOnClickListenersOnOperationButtons() {
        buttonAdd.setOnClickListener {
        }
        buttonSubtract.setOnClickListener {
        }
        buttonMultiply.setOnClickListener {
        }
        buttonDivide.setOnClickListener {
        }
    }

    private fun setOnClickListenersOnOtherButtons() {
        buttonCalculate.setOnClickListener {
        }

        buttonClear.setOnClickListener {
            currentAnswer = 0
            currentOperation = null
            numberView.text = ""
        }
    }
}