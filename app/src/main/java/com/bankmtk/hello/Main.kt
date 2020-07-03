package com.bankmtk.hello

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class Main : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startSpeech = findViewById<View>(R.id.alert_button) as Button
        startSpeech.setOnClickListener {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speech to text")
            startActivityForResult(intent, RECOGNIZER_RESULT)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == RECOGNIZER_RESULT && resultCode == RESULT_OK) {
            val matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            val speechText = findViewById<View>(R.id.greeting) as TextView
            speechText.text = matches[0].toString()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    companion object {
        private const val RECOGNIZER_RESULT = 1234
    }
}