package com.dark_phoenix09.app1pcon2k20

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController


class CategoryActivity : AppCompatActivity() {
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        var mFragment: Fragment? = null
        mFragment =QuizGameFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.frameLayout, mFragment).commit()

    }

    override fun onSupportNavigateUp(): Boolean {
        //return super.onSupportNavigateUp()
        return navController.navigateUp()
    }

}