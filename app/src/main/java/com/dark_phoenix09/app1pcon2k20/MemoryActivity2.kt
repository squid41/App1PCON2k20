package com.dark_phoenix09.app1pcon2k20

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_memory2.*
private const val TAG = "MemoryActivity2"

class MemoryActivity2 : AppCompatActivity() {
    private lateinit var buttons: List<ImageButton>
    private lateinit var cards: List<MemoryCard>
    private var indexOfSingleSelectedCard: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory2)


        val images = mutableListOf(R.drawable.ic_boy, R.drawable.ic_cloud, R.drawable.ic_home, R.drawable.ic_phone,R.drawable.ic_email,R.drawable.ic_games_24px,R.drawable.ic_cancel_24px,R.drawable.ic_lock,R.drawable.ic_point,R.drawable.ic_point,R.drawable.round)
        images.addAll(images)
        images.shuffle()

        buttons = listOf(imageButton1,imageButton2,imageButton3,imageButton4,imageButton5, imageButton6,  imageButton7, imageButton8,
            imageButton9, imageButton10, imageButton11,imageButton12,imageButton13,imageButton14,imageButton15,imageButton16,imageButton17,imageButton18,imageButton19,imageButton20)

        cards = buttons.indices.map { index ->
            MemoryCard(images[index])
        }

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                Log.i(TAG, "button clicked!!")
                updateModels(index)
                updateViews()
            }
        }
        object: CountDownTimer(30000,1000){
            override fun onTick(p0: Long) {
                textView4.text="Left: "+p0/1000;
            }

            override fun onFinish() {
                textView4.text="Left :0";
                Toast.makeText(applicationContext,"Time's off",Toast.LENGTH_LONG).show()
                val intent = Intent(this@MemoryActivity2, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                startActivityForResult(intent,1000);

            }

        }.start();

    }

    private fun updateViews() {
        cards.forEachIndexed { index, card ->
            val button = buttons[index]
            if (card.isMatched) {
                button.alpha = 0.1f
            }
            button.setImageResource(if (card.isFaceUp) card.identifier else R.drawable.ic_code)
        }
    }

    private fun updateModels(position: Int) {
        val card = cards[position]
        // Error checking:
        if (card.isFaceUp) {
            Toast.makeText(this, "Invalid move!", Toast.LENGTH_SHORT).show()
            return
        }

        if (indexOfSingleSelectedCard == null) {
            restoreCards()
            indexOfSingleSelectedCard = position
        } else {
            checkForMatch(indexOfSingleSelectedCard!!, position)
            indexOfSingleSelectedCard = null
        }
        card.isFaceUp = !card.isFaceUp
    }

    private fun restoreCards() {
        for (card in cards) {
            if (!card.isMatched) {
                card.isFaceUp = false
            }
        }
    }

    private fun checkForMatch(position1: Int, position2: Int) {
        if (cards[position1].identifier == cards[position2].identifier) {
            Toast.makeText(this, "Match found!!", Toast.LENGTH_SHORT).show()
            cards[position1].isMatched = true
            cards[position2].isMatched = true
        }
    }


}
