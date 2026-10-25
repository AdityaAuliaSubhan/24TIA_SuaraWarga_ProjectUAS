package com.example.suarawarga.Notifikasi

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import com.example.suarawarga.R
import com.example.suarawarga.databinding.ItemNotifikasiBinding

class NotifikasiAdapter(
    context: Context,
    private val listNotif: List<NotifikasiModel>
) : ArrayAdapter<NotifikasiModel>(context, 0, listNotif) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemNotifikasiBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root
        val data = listNotif[position]

        view.setOnClickListener {
            val intent = Intent(context, DetailNotifikasiActivity::class.java).apply {
                putExtra("JUDUL", data.title)
                putExtra("PESAN", data.description)
                putExtra("TANGGAL", data.time)
            }
            context.startActivity(intent)
        }

        binding.TitleNotif.text = data.title
        binding.DescNotif.text = data.description
        binding.TimeNotif.text = data.time

        binding.IconNotif.setImageResource(R.drawable.ic_notification)
        binding.IconNotif.imageTintList = ColorStateList.valueOf(
            ContextCompat.getColor(context, R.color.kuninggelap)
        )
        binding.IconNotif.backgroundTintList = ColorStateList.valueOf(
            ContextCompat.getColor(context, R.color.biruabu)
        )

        return view
    }
}