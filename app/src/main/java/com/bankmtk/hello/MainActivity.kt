package com.bankmtk.hello

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bankmtk.hello.model.BuilderGreetingPhrase
import com.bankmtk.hello.model.GreetingStrings

class MainActivity : AppCompatActivity(), GreetingStrings {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val greeting = findViewById<View>(R.id.greeting) as TextView
        val builderGreetingPhrase = BuilderGreetingPhrase(this)
        greeting.text = builderGreetingPhrase.get()
    }

    override fun getHelloer(): String {
        return resources.getString(R.string.helloer)
    }

    override fun getMorning(): String {
        return resources.getString(R.string.morning)
    }

    override fun getAfternoon(): String {
        return resources.getString(R.string.afternoon)
    }

    override fun getEvening(): String {
        return resources.getString(R.string.evening)
    }

    override fun getNight(): String {
        return resources.getString(R.string.night)
    }
}