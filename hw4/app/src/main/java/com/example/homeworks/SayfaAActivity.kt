package com.example.homeworks

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SayfaAActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sayfa_a)

        findViewById<Button>(R.id.buttonB).setOnClickListener {
            startActivity(Intent(this, SayfaBActivity::class.java))
        }
    }
}