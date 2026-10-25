package com.example.suarawarga.Usulan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.suarawarga.R
import com.example.suarawarga.databinding.FragmentUsulanBinding

class UsulanFragment : Fragment() {

    private var _binding: FragmentUsulanBinding? = null
    private val binding get() = _binding!!

    private val dataUsulan = listOf(
        mapOf("title" to "Taman Bermain Anak RW 07", "desc" to "Lapangan Utama RW 07"),
        mapOf("title" to "Pengaspalan Jalan Blok C", "desc" to "Jl. Merpati RT 02 / RW 05"),
        mapOf("title" to "Perbaikan Drainase Utama", "desc" to "Saluran Air RT 03 / RW 05"),
        mapOf("title" to "Pemasangan Lampu Jalan LED", "desc" to "Sepanjang Gang Perkutut RT 01"),
        mapOf("title" to "Renovasi Balai Warga", "desc" to "Gedung Serbaguna RW 05"),
        mapOf("title" to "Pengadaan Tempat Sampah Pilah", "desc" to "Area Pos Ronda RT 01 - RT 04"),
        mapOf("title" to "Pembangunan Pos Kamling Baru", "desc" to "Ujung Jalan Utama RT 04"),
        mapOf("title" to "Penanaman Pohon Pelindung", "desc" to "Taman Pinggir Sungai RT 02"),
        mapOf("title" to "Perbaikan Cermin Cembung Tikungan", "desc" to "Persimpangan Blok A & B"),
        mapOf("title" to "Pengadaan Alat Olahraga Luar Ruangan", "desc" to "Lapangan Voli RW 05")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsulanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Daftar Usulan Warga"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_back)
        }

        val adapter = SimpleAdapter(
            requireContext(),
            dataUsulan,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        binding.listViewUsulan.adapter = adapter

        binding.listViewUsulan.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataUsulan[position]
            val title = selectedItem["title"]
            val desc = selectedItem["desc"]
            Toast.makeText(
                requireContext(),
                "Usulan dipilih: $title ($desc)",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}