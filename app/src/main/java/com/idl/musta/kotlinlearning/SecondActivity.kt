package com.idl.musta.kotlinlearning

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_second, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.action_activity -> {
                Toast.makeText(this, "Testing", Toast.LENGTH_SHORT).show()
                val drawerIntent = Intent(this, DrawerActivity::class.java)
                startActivity(drawerIntent)
                return true
            }

            R.id.action_activity2 -> {
                val bottomNavIntent = Intent(this, BottomNavActivity::class.java)
                startActivity(bottomNavIntent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
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
