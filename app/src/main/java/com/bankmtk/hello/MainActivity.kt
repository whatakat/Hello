package com.bankmtk.hello

import android.app.job.JobInfo
import android.app.job.JobParameters
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
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
    private var jobScheduler: JobScheduler? = null
    private var jobInfo: JobInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val greeting = findViewById<View>(R.id.greeting) as TextView
        val builderGreetingPhrase = BuilderGreetingPhrase(this)
        greeting.text = builderGreetingPhrase.get()
        val componentName = ComponentName(this, NeuromJobScheduler::class.java)
        val builder = JobInfo.Builder(JOB_ID, componentName)
        builder.setPeriodic(5000)
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
        builder.setPersisted(true)
        jobInfo = builder.build()
        jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        jobScheduler!!.schedule(jobInfo!!)
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
    companion object {
        private const val JOB_ID = 101
    }
}