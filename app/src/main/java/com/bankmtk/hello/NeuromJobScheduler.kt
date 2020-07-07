package com.bankmtk.hello

import android.annotation.SuppressLint
import android.app.job.JobParameters
import android.app.job.JobService
import android.widget.Toast

class NeuromJobScheduler : JobService() {
    private var neuromJobExecutor: NeuromJobExecutor? = null
    override fun onStartJob(params: JobParameters): Boolean {
        neuromJobExecutor = @SuppressLint("StaticFieldLeak")
        object : NeuromJobExecutor() {
            override fun onPostExecute(s: String) {
                Toast.makeText(applicationContext, "Hello it's ok", Toast.LENGTH_SHORT).show()
                jobFinished(params, false)
            }
        }
        (neuromJobExecutor as NeuromJobExecutor).execute()
        return true
    }

    override fun onStopJob(params: JobParameters): Boolean {
        neuromJobExecutor!!.cancel(true)
        return false
    }
}