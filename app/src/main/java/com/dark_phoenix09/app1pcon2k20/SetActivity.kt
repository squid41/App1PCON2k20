package com.dark_phoenix09.app1pcon2k20

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.activity_set.*
import kotlinx.android.synthetic.main.gridcategoryitemlayout.view.*
import kotlinx.android.synthetic.main.set_token.view.*

class SetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set)
        setSupportActionBar(toolbar3)
        setTitle(R.string.Sets)
        imageButton7.setOnClickListener {

        }
    }

}