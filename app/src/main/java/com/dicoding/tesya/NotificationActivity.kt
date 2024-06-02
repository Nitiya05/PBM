package com.dicoding.tesya

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.tesya.databinding.ActivityNotifBinding

class NotificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotifBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotifBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "Pemberitahuan"
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
