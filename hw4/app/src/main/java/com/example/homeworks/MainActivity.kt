package com.example.homeworks
import android.content.Intent
import android.widget.Button
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonA).setOnClickListener {
            startActivity(Intent(this, SayfaAActivity::class.java))
        }

        findViewById<Button>(R.id.buttonX).setOnClickListener {
            startActivity(Intent(this, SayfaXActivity::class.java))
        }
    }
}
