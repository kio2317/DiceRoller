package com.example.diceroller


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
/**
* This activity allows the user to roll a dice and view the result
* on the screen.
*/

class MainActivity : AppCompatActivity() {

    /**
     * This method is called when the Activity is created.
     */

    override fun onCreate(savedInstanceState: Bundle?) { // 시작하기.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // activity 로부터 받아온다.\

        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() // Set a click listener on the button to roll the dice when the user taps the button
            val toast = Toast.makeText(this, " 주사위를 굴렸어요.", Toast.LENGTH_SHORT)
            toast.show() }
        // Do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {

            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource as Int)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()

        /**
         * Dice with a fixed number of sides.
         */

    }
    class Dice(private val numSides: Int) {
        /**
         * Do a random dice roll and return the result.
         */
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}