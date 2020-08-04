package com.bankmtk.hello

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bankmtk.hello.ViewAnimation.rotateFab
import com.bankmtk.hello.ViewAnimation.showIn
import com.bankmtk.hello.ViewAnimation.showOut

class FabActivity : AppCompatActivity() {
    var isRotate = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi.fabAdd.setOnClickListener(View.OnClickListener { v ->
            isRotate = rotateFab(v, !isRotate)
            if (isRotate) {
                //showIn(fabCall)
                //showIn(fabMic)
            } else {
                //showOut(fabCall)
                //showOut(fabMic)
            }
        })
    }
}