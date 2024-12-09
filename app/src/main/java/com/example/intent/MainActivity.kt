package com.example.intent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var buttonCalcBTN:Button

    private lateinit var textOutputTV:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalcBTN = findViewById(R.id.buttonCalcBTN)
        textOutputTV = findViewById(R.id.textOutputTV)

        buttonCalcBTN.setOnClickListener{
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
        val result = intent.getStringExtra("key")
        textOutputTV.text = result

    }
}