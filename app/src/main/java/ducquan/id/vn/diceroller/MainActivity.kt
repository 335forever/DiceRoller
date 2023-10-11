package ducquan.id.vn.diceroller

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll: Pair<Int,Int>  = dice.roll()

        var diceImage: ImageView = findViewById(R.id.imageView1)
        when (diceRoll.first) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            else -> diceImage.setImageResource(R.drawable.dice_6)
        }

        diceImage = findViewById(R.id.imageView2)
        when (diceRoll.second) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            else -> diceImage.setImageResource(R.drawable.dice_6)
        }

        fun showToast(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        val message:String = if (diceRoll.first==diceRoll.second) "Luck! A pair of ${diceRoll.first}"
                             else "${diceRoll.first+diceRoll.second} point! "
        showToast(this, message)
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Pair<Int,Int> {
        return Pair((1..numSides).random(), (1..numSides).random())
    }
}