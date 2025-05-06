package com.example.homeworks

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SayfaBActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sayfa_b)

        findViewById<Button>(R.id.buttonY).setOnClickListener {
            startActivity(Intent(this, SayfaYActivity::class.java))
        }
    }
}
