package com.nemesis.course.calculadora

class Operation(private val firstOperand:Double, private val secondOperand:Double) {


    //var firstOperand:Double = first
    //var secondOperand:Double = second

    fun performOperation(operation: String): Double{
        return when(operation){

            "+" -> firstOperand + secondOperand

            "-" -> firstOperand - secondOperand

            "*" -> firstOperand * secondOperand

            "/" -> firstOperand / secondOperand

            else -> 0.0
        }
    }

}