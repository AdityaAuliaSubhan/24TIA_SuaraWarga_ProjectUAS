package com.example.suarawarga.Notifikasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.suarawarga.R
import com.example.suarawarga.databinding.FragmentNotifikasiBinding
import com.example.suarawarga.Notifikasi.NotifikasiAdapter

class NotifikasiFragment : Fragment() {
    private var _binding: FragmentNotifikasiBinding? = null
    private val binding get() = _binding!!

    private val listNotif = listOf(
        NotifikasiModel(
            "Voting Musrenbang 2027 dibuka",
            "Kamu punya 3 suara untuk menentukan prioritas pembangunan kelurahan.",
            "2 jam lalu"
        ),
        NotifikasiModel(
            "Usulanmu disetujui",
            "Normalisasi drainase RT 03 masuk daftar prioritas Musrenbang.",
            "5 jam lalu"
        ),
        NotifikasiModel(
            "Tanggapan baru dari Pak Agus",
            "Di usulan Lampu penerangan jalan Blok C: \"Titik lampu sudah kami survei.\"",
            "Kemarin"
        ),
        NotifikasiModel(
            "Jadwal Gotong Royong",
            "Pembersihan saluran air dan selokan RT 03 dilaksanakan Minggu ini pukul 07.00 WIB.",
            "2 hari lalu"
        ),
        NotifikasiModel(
            "Pengaduan Diproses",
            "Laporan fasilitas jalan berlubang di RW 05 sedang ditangani tim teknis kelurahan.",
            "3 hari lalu"
        ),
        NotifikasiModel(
            "Surat Pengantar Disetujui",
            "Permohonan surat pengantar domisili kamu telah ditandatangani oleh Ketua RT 03.",
            "3 hari lalu"
        ),
        NotifikasiModel(
            "Undangan Musyawarah Warga",
            "Rapat rutin bulanan dan evaluasi Musrenbang akan diadakan Sabtu malam pukul 19.30 WIB.",
            "4 hari lalu"
        ),
        NotifikasiModel(
            "Info Posyandu Balita & Lansia",
            "Kegiatan pemeriksaan kesehatan gratis dan penimbangan balita dibuka besok di Balai RW 05.",
            "5 hari lalu"
        ),
        NotifikasiModel(
            "Informasi Pemadaman Listrik",
            "PLN mengumumkan jadwal pemeliharaan jaringan listrik wilayah Rumbai pada hari Selasa pukul 09.00 WIB.",
            "Seminggu lalu"
        ),
        NotifikasiModel(
            "Akun Warga Terverifikasi",
            "Selamat! Akun SuaraWarga milikmu sudah terverifikasi penuh oleh admin kelurahan.",
            "Seminggu lalu"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotifikasiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Notifikasi"
        (requireActivity() as AppCompatActivity).supportActionBar?.subtitle = "Notifikasi Layanan"
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)

        super.onViewCreated(view, savedInstanceState)

        val adapter = NotifikasiAdapter(requireContext(), listNotif)
        binding.listNotifikasiItems.adapter = adapter
    }

}