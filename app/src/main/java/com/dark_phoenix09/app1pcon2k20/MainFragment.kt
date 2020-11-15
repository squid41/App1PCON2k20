package com.dark_phoenix09.app1pcon2k20

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.dark_phoenix09.app1pcon2k20.SignInUp.RegisterActivity
import com.dark_phoenix09.app1pcon2k20.databinding.FragmentTitleBinding
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.Dispatchers.Main
import java.lang.reflect.Array.newInstance
import javax.xml.datatype.DatatypeFactory.newInstance


class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main, container, false)


        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageButton.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, MemoryActivity2::class.java))
                finish()
            }

        }
      imageButton22.setOnClickListener {
          requireActivity().run{
              startActivity(Intent(this,CategoryActivity::class.java))
          }
      }
        startworkoutbtn.setOnClickListener{
            requireActivity().run{
                startActivity(Intent(this, work_out1::class.java))
                finish()
            }
        }

    }


}