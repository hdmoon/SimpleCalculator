package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var numberView : TextView;

    // Buttons for 0-9
    // TODO: Too many button variables. Obviously this is not the best way.
    //       We can define a class (NumberButton), and dynamically create any buttons
    //       with their onClickListeners attached.
    lateinit var button0 : Button;
    lateinit var button1 : Button;
    lateinit var button2 : Button;
    lateinit var button3 : Button;
    lateinit var button4 : Button;
    lateinit var button5 : Button;
    lateinit var button6 : Button;
    lateinit var button7 : Button;
    lateinit var button8 : Button;
    lateinit var button9 : Button;

    // Buttons for arithmetic operations
    lateinit var buttonAdd : Button;
    lateinit var buttonSubtract : Button;
    lateinit var buttonMultiply : Button;
    lateinit var buttonDivide : Button;

    // Buttons for calculation
    lateinit var buttonCalculate : Button;

    // TODO: Implement these functionalities
    // lateinit var buttonPlusMinus : Button;
    // lateinit var buttonPoint : Button;

    var currentAnswer : Long = 0;
    var currentOperation : Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setViewProperties();
    }

    fun setViewProperties() {
        numberView = findViewById(R.id.number_view);
        numberView.setText("");

        button0 = findViewById(R.id.btn_0);
        button1 = findViewById(R.id.btn_1);
        button2 = findViewById(R.id.btn_2);
        button3 = findViewById(R.id.btn_3);
        button4 = findViewById(R.id.btn_4);
        button5 = findViewById(R.id.btn_5);
        button6 = findViewById(R.id.btn_6);
        button7 = findViewById(R.id.btn_7);
        button8 = findViewById(R.id.btn_8);
        button9 = findViewById(R.id.btn_9);

        buttonAdd = findViewById(R.id.btn_add);
        buttonSubtract = findViewById(R.id.btn_subtract);
        buttonMultiply = findViewById(R.id.btn_multiply);
        buttonDivide = findViewById(R.id.btn_divide);

        buttonCalculate = findViewById(R.id.btn_calculate);
    }

}