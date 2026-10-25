package com.example.suarawarga.Notifikasi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.suarawarga.R
import com.example.suarawarga.databinding.ActivityDetailNotifikasiBinding

class DetailNotifikasiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailNotifikasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailNotifikasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handling sistem inset untuk Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Tangkap data yang dikirim dari Adapter / Intent
        val judul = intent.getStringExtra("JUDUL")
        val pesan = intent.getStringExtra("PESAN")
        val tanggal = intent.getStringExtra("TANGGAL")

        // Tampilkan data ke View
        binding.textJudulNotifikasi.text = judul
        binding.textPesanNotifikasi.text = pesan
        binding.textTanggalNotifikasi.text = tanggal

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Detail Notifikasi"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_back)

        }
    }
}