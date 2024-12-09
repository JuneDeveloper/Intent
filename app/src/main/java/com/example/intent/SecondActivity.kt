package com.example.intent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editFirstET:EditText
    private lateinit var editSecondET:EditText

    private lateinit var buttonSumBTN:Button
    private lateinit var buttonDifBTN:Button
    private lateinit var buttonMultBTN:Button
    private lateinit var buttonDivBTN:Button
    private lateinit var buttonReturnResultBTN:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        editFirstET = findViewById(R.id.editFirstET)
        editSecondET = findViewById(R.id.editSecondET)

        buttonSumBTN = findViewById(R.id.buttonSumBTN)
        buttonDifBTN = findViewById(R.id.buttonDifBTN)
        buttonMultBTN = findViewById(R.id.buttonMultBTN)
        buttonDivBTN = findViewById(R.id.buttonDivBTN)
        buttonReturnResultBTN = findViewById(R.id.buttonReturnResultBTN)

        buttonSumBTN.setOnClickListener(this)
        buttonDifBTN.setOnClickListener(this)
        buttonMultBTN.setOnClickListener(this)
        buttonDivBTN.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val x = Integer.parseInt(editFirstET.text.toString()).toDouble()
        val y = Integer.parseInt(editSecondET.text.toString()).toDouble()

        val result = when(v.id) {
            R.id.buttonSumBTN -> Operation(x,y).sum()
            R.id.buttonDifBTN -> Operation(x,y).dif()
            R.id.buttonMultBTN -> Operation(x,y).mult()
            R.id.buttonDivBTN -> Operation(x,y).div()
            else -> 0
        }
        buttonReturnResultBTN.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("key",result.toString())
            startActivity(intent)
        }
    }

}