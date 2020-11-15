package com.dark_phoenix09.app1pcon2k20

import android.content.Intent
import android.content.IntentSender
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.dark_phoenix09.app1pcon2k20.SignInUp.toast
import kotlinx.android.synthetic.main.activity_work_out2__exercise.*

class work_out2_Exercise : AppCompatActivity() {

    private var restTimer: CountDownTimer?=null
    private var restProcess=0

    private var exerciseTimer: CountDownTimer?=null
    private var exerciseProcess=0
    private var exerciseTimerDuration: Long=30

    private var exerciseList:ArrayList<ExerciseModel>? = null
    private var currentExercisePositions=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_out2__exercise)
        setSupportActionBar(toolbar_exercise_activity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar_exercise_activity.setNavigationOnClickListener {
            onBackPressed()
        }
        exerciseList= Constants.defaultExerciseList()
        setRestView()
    }

    override fun onDestroy() {
        if(restTimer!=null) {
            restTimer!!.cancel()
            restProcess=0
        }
        super.onDestroy()

    }
    private fun setRestProgressBar(){
        progressBar.progress=restProcess
        restTimer=object : CountDownTimer(10000,1000)
        {
            override fun onTick(millisUnitFinished: Long) {
                restProcess++
                progressBar.progress=10-restProcess
                tvTimer.text=(10-restProcess).toString()
            }

            override fun onFinish() {
                currentExercisePositions++
                setExerciseView()
            }
        }.start()
    }
    private fun setExerciseProgressBar(){
        progressBarExercise.progress=exerciseProcess
        exerciseTimer=object : CountDownTimer(exerciseTimerDuration*1000,1000){
            override fun onTick(millisUnitFinished: Long) {
                exerciseProcess++
                progressBarExercise.progress=exerciseTimerDuration.toInt()-exerciseProcess
                tvExerciseTimer.text=(exerciseTimerDuration.toInt()-exerciseProcess).toString()
            }
            override fun onFinish() {
                if(currentExercisePositions<exerciseList?.size!!-1)
                {
                    setRestView()
                }
                else
                {
                    finish()
                    startActivity(Intent(this@work_out2_Exercise,Finish_workout::class.java))
                }
            }
        }.start()
    }
    private fun setExerciseView(){
        llRestView.visibility=View.GONE
        llExerciseView.visibility=View.VISIBLE
        if(exerciseTimer!=null)
        {
            exerciseTimer!!.cancel()
            exerciseProcess=0
        }
        setExerciseProgressBar()
        ivImage.setImageResource(exerciseList!![currentExercisePositions].getImage())
        tvExerciseName.text=exerciseList!![currentExercisePositions].getName()
    }
    private fun setRestView(){
        llRestView.visibility= View.VISIBLE
        llExerciseView.visibility=View.GONE
        if(restTimer!=null)
        {
            restTimer!!.cancel()
            restProcess=0
        }
        tvUpcomingExerciseName.text= exerciseList!![currentExercisePositions+1].getName()
        setRestProgressBar()
    }
}