package com.example.practica03k

class Calculadora {

    var num1: Int=0;
    var num2: Int=0;

    constructor(num1:Int,num2:Int){
        this.num1=num1;
        this.num2=num2;
    }
    fun suma():Int{
        return num1+num2
    }

    fun resta():Int{
        return num1-num2
    }

    fun multiplicar():Int{
        return num1*num2
    }
    fun division():Int{
        var total=0;
        if(num2!=0)
        {
            total=num1/num2
        }
        return total
    }




}