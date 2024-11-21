package com.example.task_027

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mainTextTV: TextView
    private lateinit var transitButtonBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        transitButtonBTN.setOnClickListener{
            val intent = Intent(this, WardrobeActivity::class.java)
            startActivity(intent)
        }
    }

    fun init() {
        mainTextTV = findViewById(R.id.mainTextTV)
        transitButtonBTN = findViewById(R.id.transitButtonBTN)
    }
}