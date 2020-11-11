package com.dark_phoenix09.app1pcon2k20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.dark_phoenix09.app1pcon2k20.databinding.FragmentQuizWonBinding
import kotlinx.android.synthetic.main.fragment_quiz_won.*

class QuizWonFragment : Fragment() {
    lateinit var binding:FragmentQuizWonBinding
    var earnedScore:String = ""
    var wrongAnswerText:String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_quiz_won,container,false)
       /* binding.btnPlayNext.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_quizWonFragment_to_titleFragment)
        }*/
        binding.quizwon = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let{
            val args = QuizWonFragmentArgs.fromBundle(it)
            earnedScore = args.score.toString()
            if (args.wrongAnswers.isNotEmpty()){
                yourwronganswer.visibility = View.VISIBLE
                txt_wrong_answer.visibility = View.VISIBLE

                for (ans in args.wrongAnswers){
                    wrongAnswerText = wrongAnswerText + ans + "\n"
                }
            }
        }
    }


}
