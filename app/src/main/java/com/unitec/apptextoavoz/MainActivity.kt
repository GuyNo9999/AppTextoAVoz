package com.unitec.apptextoavoz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    //Este objeto es el intermediario entre nuestra app y TextToSpeech
    private  var tts:TextToSpeech?=null
    //Elsiguiente tipo de inf es un entero
    private val CODIGO_PETICION=100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main)
        //Iniciamos i la var tts para que ya no este null
        tts = TextToSpeech(this,this)
        //Mensaje de bienvenida
        Timer("Bienvenida",false).schedule(1000){
            tts!!.speak(
                    "hola", TextToSpeech.QUEUE_FLUSH, null, ""
            )
        }
    }

    override fun onInit(estado: Int) {
        //inicie cuande arranque la app
        if(estado==TextToSpeech.SUCCESS){
            //Si el if se cumplio la ejecucion seguira aqui adentro
            var local=Locale("spa", "MEX")
            //Para saber si va bien
            var resultado=tts!!.setLanguage(local)
            if (resultado==TextToSpeech.LANG_MISSING_DATA){
                Log.i("MALO","NO FUNIONO, ALGO ANDA MAL")
            }
        }
    }
}