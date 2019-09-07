package com.nemesis.course.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var txtDisplay: TextView

    private var currentNumber = ""
    private var accumulator = 0.0
    private var operation:String = ""
    private var isTypingANumber = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtDisplay = findViewById(R.id.display)

        val btnClear:Button = findViewById(R.id.key_clear)

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


    }

    override fun onClick(v: View?) {
        if( v is Button){

            isTypingANumber = true

            currentNumber += v.text
            txtDisplay.text = currentNumber
        }
    }

    private fun performOperation(operation:String){
        if(isTypingANumber){
            val number = currentNumber.toDouble()

            if(operation == "="){

                val result = when(this.operation){

                    "+" -> accumulator + number

                    "-" -> accumulator - number

                    "*" -> accumulator * number

                    "/" -> accumulator / number

                    else -> 0.0
                }

                txtDisplay.text = result.toString()

            }else{
                accumulator = number
                currentNumber = ""
                this.operation = operation
            }


        }
    }

}
