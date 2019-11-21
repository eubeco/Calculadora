package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Main2Activity : AppCompatActivity() {


    companion object {
        const val RESULTADO = "resultado"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        MostrarResultado()

    }

    fun MostrarResultado(){
        val resultado = intent .getIntExtra(RESULTADO , 0 )
        val textViewRtdo = findViewById(R.id.textView_resultado) as TextView
        textViewRtdo.setText(resultado.toString())
    }

    fun backMe (view: View) {
        val backIntent = Intent( this , MainActivity:: class . java )
        startActivity(backIntent)
    }
}
