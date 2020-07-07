package com.bankmtk.hello

import android.os.AsyncTask

open class NeuromJobExecutor : AsyncTask<Void?, Void?, String>() {

    override fun doInBackground(vararg params: Void?): String {
        return "Background finish"
    }
}