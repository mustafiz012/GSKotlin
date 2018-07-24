package com.idl.musta.kotlinlearning

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        btnToast.setOnClickListener { toastMe() }

        btnCount.setOnClickListener { countMe() }

        btnRandom.setOnClickListener {
            val randomIntent = Intent(this, SecondActivity::class.java)
            val counter = showCountTextView.text.toString();
            randomIntent.putExtra(SecondActivity.TOTAL_COUNT, Integer.parseInt(counter))
            startActivity(randomIntent)
        }
    }

    private fun toastMe() {
        Toast.makeText(this, "Hello toast!", Toast.LENGTH_SHORT).show()
    }

    private fun countMe() {
//        val showCountTextView = findViewById(R.id.textView) as TextView
        val countString = showCountTextView.text.toString()
        var count: Int = Integer.parseInt(countString)
        count++
        showCountTextView.text = count.toString()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
