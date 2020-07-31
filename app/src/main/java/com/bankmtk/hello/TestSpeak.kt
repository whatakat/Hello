package com.bankmtk.hello

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.view.View
import android.widget.Button
import java.util.*

class TestSpeak : Activity(), OnInitListener {
    private var myTTS: TextToSpeech? = null
    private val phrases: MutableList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        phrases.add("Hello, Android, goodbye IPhone")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startButton = findViewById<View>(R.id.bottom) as Button
        startButton.setOnClickListener {
            val checkIntent = Intent()
            checkIntent.action = TextToSpeech.Engine.ACTION_CHECK_TTS_DATA
            startActivityForResult(checkIntent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == 1) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                myTTS = TextToSpeech(this, this)
                myTTS!!.language = Locale.US
            } else {
                val ttsLoadIntent = Intent()
                ttsLoadIntent.action = TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA
                startActivity(ttsLoadIntent)
            }
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val n = 0
            myTTS!!.speak(phrases[n], TextToSpeech.QUEUE_FLUSH, null)
        } else if (status == TextToSpeech.ERROR) {
            myTTS!!.shutdown()
        }
    }
}