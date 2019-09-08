package com.nemesis.course.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var txtDisplay: TextView

    private val processor = Processor()

    private var currentNumber = ""
    private var isTypingANumber = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtDisplay = findViewById(R.id.display)

        // Infiere el tipo de de valor de la variable
        val btnKey0 = findViewById<Button>(R.id.key_0)
        btnKey0.setOnClickListener(this)

        // Infiere el tipo de retorno de la función
        val btnKey1:Button = findViewById(R.id.key_1)
        btnKey1.setOnClickListener(this)

        val btnKey2:Button = findViewById(R.id.key_2)
        btnKey2.setOnClickListener(this)

        val btnKey3:Button = findViewById(R.id.key_3)
        btnKey3.setOnClickListener(this)

        val btnKey4:Button = findViewById(R.id.key_4)
        btnKey4.setOnClickListener(this)

        val btnKey5:Button = findViewById(R.id.key_5)
        btnKey5.setOnClickListener(this)

        val btnKey6:Button = findViewById(R.id.key_6)
        btnKey6.setOnClickListener(this)

        val btnKey7:Button = findViewById(R.id.key_7)
        btnKey7.setOnClickListener(this)

        val btnKey8:Button = findViewById(R.id.key_8)
        btnKey8.setOnClickListener(this)

        val btnKey9:Button = findViewById(R.id.key_9)
        btnKey9.setOnClickListener(this)

        val btnAddition:Button = findViewById(R.id.key_addition)

        btnAddition.setOnClickListener {
            performOperation(btnAddition.text.toString())
        }

        val btnSubstraction:Button = findViewById(R.id.key_substraction)

        btnSubstraction.setOnClickListener {
            performOperation(btnSubstraction.text.toString())
        }

        val btnMultiplication:Button = findViewById(R.id.key_multiplication)

        btnMultiplication.setOnClickListener {
            performOperation(btnMultiplication.text.toString())
        }

        val btnDivision:Button = findViewById(R.id.key_division)
        btnDivision.setOnClickListener {
            performOperation(btnDivision.text.toString())
        }

        val btnEquals:Button = findViewById(R.id.key_equals)
        btnEquals.setOnClickListener {

            performOperation(btnEquals.text.toString())

        }

        val btnClear:Button = findViewById(R.id.key_clear)
        btnClear.setOnClickListener {

            clear()
        }

    }

    override fun onClick(v: View?) {
        if( v is Button){

            if(isTypingANumber){
                currentNumber += v.text.toString()
            }else{
                isTypingANumber = true
                currentNumber = v.text.toString()
            }

            txtDisplay.text = currentNumber

        }
    }

    private fun performOperation(operation:String){

        isTypingANumber = false

        if(processor.hasFirstOperand()){

            val operand = txtDisplay.text.toString().toDouble()
            processor.perfomOperation(operand)
            processor.operator = operation

        }else{

            val operand = txtDisplay.text.toString().toDouble()
            processor.setOperand(operand)
            processor.operator = operation

        }

        txtDisplay.text = processor.getResult().toString()

    }

    private fun clear(){
        txtDisplay.text = "0"
        processor.clear()

        Log.w("clear()", "Se ejecutó!")

    }

}
