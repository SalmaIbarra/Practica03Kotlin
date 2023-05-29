package com.example.practica03k

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var btnIngresar : Button
    private lateinit var btnSalir : Button
    private lateinit var txtUsuario : EditText
    private lateinit var txtContraseña: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciarComponentes();

        btnIngresar.setOnClickListener { btnIngresar() }
        btnSalir.setOnClickListener { btnSalir() }



    }

    private fun iniciarComponentes(){
        btnIngresar = findViewById(R.id.btnIngresar)
        btnSalir = findViewById(R.id.btnSalir)
        txtUsuario= findViewById(R.id.txtUsuario)
        txtContraseña=findViewById(R.id.txtContraseña)
    }

    private fun btnIngresar()
    {
        var strUsuario:String;
        var strContraseña:String;

        strUsuario=applicationContext.resources.getString(R.string.usuario);
        strContraseña=applicationContext.resources.getString(R.string.contraseña);

        if(strUsuario.toString().equals(txtUsuario.text.toString()) && strContraseña.toString().equals(txtContraseña.text.toString()))
        {
            var bundle=Bundle()
            bundle.putString("Usuario",txtUsuario.text.toString())




            //Intert para llamar otra actividad
            val intent= Intent(this@MainActivity,CalculadoraActivity::class.java)
            intent.putExtras(bundle)
            //Iniciar la actividad esperando o no respuesta
            startActivity(intent)
        }
        else{
            Toast.makeText(this.applicationContext,"El usuario o contraseña no es valido",Toast.LENGTH_SHORT).show();
        }
    }
    fun btnSalir()
    {
        var confirmar = AlertDialog.Builder(this)

        confirmar.setTitle("Calculadora")
        confirmar.setMessage("¿Desea Salir?")
        confirmar.setPositiveButton("Confirmar"){dialogInterface,which->finish()}
        confirmar.setNegativeButton("Cancelar"){dialogInterface,which->}

        confirmar.show();
    }
}