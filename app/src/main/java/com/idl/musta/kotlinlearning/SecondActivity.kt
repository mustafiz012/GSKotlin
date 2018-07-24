package com.idl.musta.kotlinlearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import java.util.*

class SecondActivity : AppCompatActivity() {

    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        generateRandomNumber()
    }

    private fun generateRandomNumber() {
        val count = intent.getIntExtra(TOTAL_COUNT, 0)
        //Generate random number
        val random = Random()
        var randomInt = 0
        if (count > 0) {
            randomInt = random.nextInt(count + 1)
        }

        randomNumber.text = String.format("%s", Integer.toString(randomInt))

        random_label.text = getString(R.string.change_text_again2, count)
    }
}
