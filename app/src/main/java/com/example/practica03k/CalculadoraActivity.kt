package com.example.practica03k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog


private lateinit var btnSumar:Button
private lateinit var btnRestar:Button
private lateinit var btnMultiplicar:Button
private lateinit var btnDividir:Button
private lateinit var btnRegresar:Button
private lateinit var btnLimpiar:Button
private lateinit var lblUsuario:TextView
private lateinit var lblResultado:TextView
private lateinit var txtUno:EditText
private lateinit var txtDos:EditText


//Declarar el objeto calculadora

private var calculadora=Calculadora(0,0)

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
        //Llamar funcion
        iniciarComponentes();
        //Obtener los datos del MainActivity
        var strUsuario:String;


        strUsuario=applicationContext.resources.getString(R.string.usuario);
        lblUsuario.text=strUsuario.toString();



        //Icono para APP
        //Imagen en mipmap
        //Imagen en mainActivty
        btnSumar.setOnClickListener{btnSumar()}
        btnRestar.setOnClickListener { btnRestar() }
        btnMultiplicar.setOnClickListener { btnMultiplicar() }
        btnDividir.setOnClickListener { btnDividir() }
        btnLimpiar.setOnClickListener { btnLimpiar() }
        btnRegresar.setOnClickListener { btnRegresar() }

    }
    //Creamos una funcion para iniciar los componentes
    private fun iniciarComponentes()
    {
        //Vincular los botones con las variables creadas

        //Botones
        btnSumar= findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar= findViewById(R.id.btnMulti);
        btnDividir= findViewById(R.id.btnDivision);
        btnRegresar= findViewById(R.id.btnRegresar);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        //Letreros
        lblUsuario= findViewById(R.id.lblUsuario);
        lblResultado= findViewById(R.id.lblResultado);
        //Textboxs
        txtUno=findViewById(R.id.txtNum1);
        txtDos=findViewById(R.id.txtNum2);
    }

    fun btnSumar()
    {
        calculadora.num1 = txtUno.text.toString().toInt();
        calculadora.num2 = txtDos.text.toString().toInt();
        var total = calculadora.suma()
        lblResultado.text=total.toString();
    }

    fun btnRestar()
    {
        calculadora.num1 = txtUno.text.toString().toInt();
        calculadora.num2 = txtDos.text.toString().toInt();
        var total = calculadora.resta();
        lblResultado.text=total.toString();
    }

    fun btnMultiplicar()
    {
        calculadora.num1 = txtUno.text.toString().toInt();
        calculadora.num2 = txtDos.text.toString().toInt();
        var total = calculadora.multiplicar();
        lblResultado.text=total.toString();
    }

    fun btnDividir()
    {
        calculadora.num1 = txtUno.text.toString().toInt();
        calculadora.num2 = txtDos.text.toString().toInt();
        var total = calculadora.division();
        lblResultado.text=total.toString();
    }

    fun btnLimpiar()
    {
        lblResultado.text=""
        txtUno.setText("")
        txtDos.setText("")
    }

    fun btnRegresar()
    {
        var confirmar = AlertDialog.Builder(this)

        confirmar.setTitle("Calculadora")
        confirmar.setMessage("¿Regresar al MainActivity?")
        confirmar.setPositiveButton("Confirmar"){dialogInterface,which->finish()}
        confirmar.setNegativeButton("Cancelar"){dialogInterface,which->}

        confirmar.show();

    }

}