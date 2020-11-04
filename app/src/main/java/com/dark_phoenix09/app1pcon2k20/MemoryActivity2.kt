package com.dark_phoenix09.app1pcon2k20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val images = mutableListOf(R.drawable.ic_boy, R.drawable.ic_cloud, R.drawable.ic_home, R.drawable.ic_phone)
        // Add each image twice so we can create pairs
        images.addAll(images)
        // Randomize the order of images
        images.shuffle()

        buttons = listOf(imageButton1, imageButton2, imageButton3, imageButton4, imageButton5,
            imageButton6, imageButton7, imageButton8)

        cards = buttons.indices.map { index ->
            MemoryCard(images[index])
        }

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                Log.i(TAG, "button clicked!!")
                // Update models
                updateModels(index)
                // Update the UI for the game
                updateViews()
            }
        }
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
        // Three cases
        // 0 cards previously flipped over => restore cards + flip over the selected card
        // 1 card previously flipped over => flip over the selected card + check if the images match
        // 2 cards previously flipped over => restore cards + flip over the selected card
        if (indexOfSingleSelectedCard == null) {
            // 0 or 2 selected cards previously
            restoreCards()
            indexOfSingleSelectedCard = position
        } else {
            // exactly 1 card was selected previously
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
