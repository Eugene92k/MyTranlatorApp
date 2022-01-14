package com.example.mytranlatorapp.presenter.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.mytranlatorapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val iv_note : ImageView = findViewById(R.id.iv_note)
        val tv_note: TextView = findViewById(R.id.tv_note)

        tv_note.alpha = 0f
        tv_note.animate().setDuration(2000).alpha(1f)
        iv_note.alpha = 0f
        iv_note.animate().setDuration(2000).alpha(1f).withEndAction{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }

    }
}