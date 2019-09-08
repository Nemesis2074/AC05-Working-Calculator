package com.nemesis.course.calculadora

class Processor {

    private var accumulator: Double? = null

    var operator: String = ""

    fun setOperand(operand: Double){
        accumulator = operand
    }

    /*fun setOperation(operation:String){
        this.operator = operation
    }*/

    fun perfomOperation(secondOperand: Double){

        val accumulator = this.accumulator
        if(accumulator != null) {

            val operation = Operation(accumulator, secondOperand)

            this.accumulator = operation.performOperation(operator)
        }
    }

    fun hasFirstOperand(): Boolean{
        return accumulator != null
    }

    fun getResult(): Double{
        //En una linea
        return accumulator ?: 0.0

        // Es lo mismo que esto:
        /*
        val accumulator = this.accumulator
        if(accumulator != null){
            return accumulator
        }
        return 0.0*/
    }

    fun clear(){
        accumulator = null
        operator = ""
    }

}