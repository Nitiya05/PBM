package com.dicoding.tesya

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dicoding.tesya.R
import com.dicoding.tesya.databinding.ActivityDetailGrafikBinding

class DetailGrafikActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailGrafikBinding
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailGrafikBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisialisasi toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Aktifkan Edge-to-Edge
        enableEdgeToEdge()

        // Menambahkan tombol kembali (back button)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Mengubah judul toolbar menjadi "Detail Grafik"
        supportActionBar?.title = "Detail Grafik"

        // Menambahkan listener untuk mengatur padding saat terjadi inset sistem
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

