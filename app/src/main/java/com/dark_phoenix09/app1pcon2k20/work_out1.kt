package com.dark_phoenix09.app1pcon2k20

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.work_out1.*

class work_out1 : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.work_out1)
        llStart.setOnClickListener {
//            Toast.makeText(this,
//            "Button works finally",
//            Toast.LENGTH_LONG
//            ).show()
            startActivity(Intent(this,work_out2_Exercise::class.java))
        }
    }

}