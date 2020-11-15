package com.dark_phoenix09.app1pcon2k20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.dark_phoenix09.app1pcon2k20.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {
    lateinit var binding : FragmentTitleBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_title,container,false)
  /*binding.btnPlay.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_titleFragment_to_quizGameFragment)
        }*/
        return binding.root
    }


}