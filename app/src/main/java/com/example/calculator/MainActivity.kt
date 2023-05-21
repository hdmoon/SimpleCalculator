package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG: String = "Calculator"
        private const val DEBUG: Boolean = true
    }

    private lateinit var numberView: TextView

    // Buttons for 0-9
    // TODO: Too many button variables. Obviously this is not the best way.
    //       We can define a class (NumberButton), and dynamically create any buttons
    //       with their onClickListeners attached.
    private lateinit var button0: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button

    private lateinit var buttonAdd: Button
    private lateinit var buttonSubtract: Button
    private lateinit var buttonMultiply: Button
    private lateinit var buttonDivide: Button

    private lateinit var buttonCalculate: Button
    private lateinit var buttonClear: Button

    // TODO: Implement these functionalities
    // lateinit var buttonPlusMinus: Button
    // lateinit var buttonPoint: Button

    private var startNewNumberWhenTypingStarts: Boolean = true
    private var leftOperand: Double? = null
    private var rightOperand: Double? = null
    private var currentOperation: Button? = null
    private var pendingOperationIsOnlyPerformedByCalculateButton = false

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
        button0.setOnClickListener { writeDigit(it as Button) }
        button1.setOnClickListener { writeDigit(it as Button) }
        button2.setOnClickListener { writeDigit(it as Button) }
        button3.setOnClickListener { writeDigit(it as Button) }
        button4.setOnClickListener { writeDigit(it as Button) }
        button5.setOnClickListener { writeDigit(it as Button) }
        button6.setOnClickListener { writeDigit(it as Button) }
        button7.setOnClickListener { writeDigit(it as Button) }
        button8.setOnClickListener { writeDigit(it as Button) }
        button9.setOnClickListener { writeDigit(it as Button) }
    }

    @SuppressLint("SetTextI18n")
    private fun writeDigit(digitButton: Button) {
        val currentNumber: String = numberView.text.toString()
        val digitString = digitButton.text.toString()
        if (digitString.toDouble() == 0.0 && currentNumber == "0") {
            // TODO: Handle the decimal point button event
            return
        }
        if (startNewNumberWhenTypingStarts) {
            numberView.text = digitString
            startNewNumberWhenTypingStarts = false
        } else {
            numberView.text = currentNumber + digitString
        }
        rightOperand = numberView.text.toString().toDouble()
    }

    private fun setOnClickListenersOnOperationButtons() {
        buttonAdd.setOnClickListener { setOperation(it as Button) }
        buttonSubtract.setOnClickListener { setOperation(it as Button) }
        buttonMultiply.setOnClickListener { setOperation(it as Button) }
        buttonDivide.setOnClickListener { setOperation(it as Button) }
    }

    private fun setOperation(operation: Button) {
        if (hasPendingOperation() && !pendingOperationIsOnlyPerformedByCalculateButton) {
            val result = calculate(leftOperand as Double, rightOperand as Double,
                currentOperation as Button) ?: return

            leftOperand = result
            numberView.text = formatDouble(result)
        }

        if (numberView.text.toString().isNotEmpty()) {
            leftOperand = numberView.text.toString().toDouble()
        }

        currentOperation = operation
        rightOperand = null
        startNewNumberWhenTypingStarts = true
        pendingOperationIsOnlyPerformedByCalculateButton = false
    }

    private fun hasPendingOperation(): Boolean {
        return leftOperand != null && currentOperation != null && rightOperand != null
    }

    // Use cases:
    // Case 0. 1 =          (Should show 1)
    // Case 1. 1 + 2 =      (Should show 3)
    // Case 2. 2 + 3 + 4    (Should show 5)
    // Case 3. 2 + 3 = =    (Should show 5 then 8)

    private fun setOnClickListenersOnOtherButtons() {
        buttonCalculate.setOnClickListener {
            if (leftOperand == null) {
                return@setOnClickListener
            }

            if (!hasPendingOperation()) {
                return@setOnClickListener
            }

            val result = calculate(leftOperand as Double, rightOperand as Double,
                currentOperation as Button) ?: return@setOnClickListener

            leftOperand = result
            numberView.text = formatDouble(result)

            pendingOperationIsOnlyPerformedByCalculateButton = true
            startNewNumberWhenTypingStarts = true
        }

        buttonClear.setOnClickListener {
            clear()
        }
    }

    private fun clear() {
        startNewNumberWhenTypingStarts = true
        pendingOperationIsOnlyPerformedByCalculateButton = false
        leftOperand = null
        rightOperand = null
        currentOperation = null

        numberView.text = ""
    }

    private fun calculate(leftOperand: Double, rightOperand: Double, operation: Button): Double? {
        val result: Double?

        when (operation) {
            buttonAdd -> result = leftOperand + rightOperand
            buttonSubtract -> result = leftOperand - rightOperand
            buttonMultiply -> result = leftOperand * rightOperand
            buttonDivide -> {
                if (rightOperand == 0.0) {
                    if (DEBUG) {
                        Log.d(TAG, "Divide by 0. Clearing the state.")
                    }
                    clear()
                    result = null
                } else {
                    result = leftOperand / rightOperand
                }
            }
            else -> {
                Log.e(TAG, "Should not reach here! Invalid operand ${operation.text}")
                result = null
            }
        }
        if (DEBUG) {
            Log.d(TAG, "$leftOperand ${operation.text} $rightOperand = $result")
        }
        return result
    }

    private fun formatDouble(number: Double): String {
        return if (number % 1.0 != 0.0) String.format("%s", number)
        else String.format("%.0f", number)
    }
}