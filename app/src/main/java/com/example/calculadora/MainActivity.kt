package com.example.calculadora

import android.app.ProgressDialog.show
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_0 = findViewById<Button>(R.id.boton0)
        val btn_1 = findViewById<Button>(R.id.boton1)
        val btn_2 = findViewById<Button>(R.id.boton2)
        val btn_3 = findViewById<Button>(R.id.boton3)
        val btn_4 = findViewById<Button>(R.id.boton4)
        val btn_5 = findViewById<Button>(R.id.boton5)
        val btn_6 = findViewById<Button>(R.id.boton6)
        val btn_7 = findViewById<Button>(R.id.boton7)
        val btn_8 = findViewById<Button>(R.id.boton8)
        val btn_9 = findViewById<Button>(R.id.boton9)

        btn_0.setOnClickListener{
            AnyadirAOperacion("0")
        }
        btn_1.setOnClickListener{
            AnyadirAOperacion("1")
        }
        btn_2.setOnClickListener{
            AnyadirAOperacion("2")
        }
        btn_3.setOnClickListener{
            AnyadirAOperacion("3")
        }
        btn_4.setOnClickListener{
            AnyadirAOperacion("4")
        }
        btn_5.setOnClickListener{
            AnyadirAOperacion("5")
        }
        btn_6.setOnClickListener{
            AnyadirAOperacion("6")
        }
        btn_7.setOnClickListener{
            AnyadirAOperacion("7")
        }
        btn_8.setOnClickListener{
            AnyadirAOperacion("8")
        }
        btn_9.setOnClickListener{
            AnyadirAOperacion("9")
        }

        val btn_borrar = findViewById<Button>(R.id.boton_borrar)
        btn_borrar.setOnClickListener{
            LimpiarOperacion()
        }

        val btn_sumar = findViewById<Button>(R.id.botonsuma)
        btn_sumar.setOnClickListener{
            AnyadirAOperacion("+")
        }

        val btn_restar = findViewById<Button>(R.id.botonresta)
        btn_restar.setOnClickListener{
            AnyadirAOperacion("-")
        }

        val btn_multiplicar = findViewById<Button>(R.id.botonmultiplicacion)
        btn_multiplicar.setOnClickListener{
            AnyadirAOperacion("*")
        }

        val btn_dividir = findViewById<Button>(R.id.botondivision)
        btn_dividir.setOnClickListener{
            AnyadirAOperacion("/")
        }

        val btn_operar = findViewById<Button>(R.id.boton_operar)
        btn_operar.setOnClickListener{
            if (!btn_operar.text.toString().isEmpty()) MostrarResultado(Operar())
        }
    }

    fun AnyadirAOperacion(operando : String){
        var operacion = findViewById<TextView>(R.id.idoperacion)

        operacion.text= (operacion.text.toString() + operando)

    }
    fun LimpiarOperacion(){
        var operacion = findViewById<TextView>(R.id.idoperacion)

        operacion.text= ""
    }

    fun MostrarResultado (Resultado : Int) {
        // Create an Intent to start the second activity
        val resultadoIntent = Intent ( this , Main2Activity :: class .java)

        // Add the resultado to the extras for the Intent.
        resultadoIntent.putExtra( Main2Activity.RESULTADO, Resultado)
        // Start the new activity.
        startActivity(resultadoIntent)
    }
    fun Operar(): Int{
        var Resultado : Int = 666
        val operacion = findViewById<TextView>(R.id.idoperacion)
        var operando1: String = ""
        var operando2: String = ""
        var operador1: String = ""
        var i : Int = 0

//Obtener operando1
        if (operacion.text.toString().isEmpty())
        {
            Toast.makeText(this,"¡ERROR! No hay datos.",Toast.LENGTH_LONG).show()
            return Resultado
        }


        while (i < operacion.text.toString().length && operacion.text.toString()[i] != '+' && operacion.text.toString()[i] != '-' && operacion.text.toString()[i] != '*' && operacion.text.toString()[i] != '/'  && operacion.text.toString()[i].isDigit()) {
            operando1 = operando1 + operacion.text.toString()[i]
            i += 1
        }
//Obtener operador1
        if (i == operacion.text.toString().length)
        {
            Toast.makeText(this,"¡ERROR! No hay operador",Toast.LENGTH_LONG).show()
            return Resultado
        }

        when(operacion.text.toString()[i]){
            '+' -> operador1 = operador1 + '+'
            '-' -> operador1 = operador1 + '-'
            '*' -> operador1 = operador1 + '*'
            '/' -> operador1 = operador1 + '/'
            else -> {
                Toast.makeText(this,"¡ERROR! No hay operador",Toast.LENGTH_LONG).show()
                return Resultado
            }
        }
        i += 1

        if (i == operacion.text.toString().length)
        {
            Toast.makeText(this,"¡ERROR! No hay operando2",Toast.LENGTH_LONG).show()
            return Resultado
        }

//Obtener operando2
        while (i < operacion.text.toString().length && operacion.text.toString()[i] != '+' && operacion.text.toString()[i] != '-' && operacion.text.toString()[i] != '*' && operacion.text.toString()[i] != '/'  && operacion.text.toString()[i].isDigit() ) {
            operando2 = operando2 + operacion.text.toString()[i]
            i += 1
        }

        if (operador1.isEmpty() || operando1.isEmpty() || operando2.isEmpty())
        {
            Toast.makeText(this,"¡ERROR! No hay operador, operando1 u operando2.",Toast.LENGTH_LONG).show()
            return Resultado
        }

//Finalmente operamos
        when (operador1){
            "+" -> Resultado = operando1.toInt() + operando2.toInt()
            "*" -> Resultado = operando1.toInt() * operando2.toInt()
            "/" -> Resultado = operando1.toInt() / operando2.toInt()
            "-" -> Resultado = operando1.toInt() - operando2.toInt()
        }
        return Resultado
    }


}
