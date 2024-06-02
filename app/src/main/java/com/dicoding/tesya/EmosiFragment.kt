package com.dicoding.tesya

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class EmosiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_emosi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Temukan button di layout
        val btnLihatLebihLanjut = view.findViewById<Button>(R.id.btnLihatLebihLanjut)

        // Atur OnClickListener untuk button
        btnLihatLebihLanjut.setOnClickListener {
            // Intent untuk memulai DetailGrafikActivity
            val intent = Intent(requireContext(), DetailGrafikActivity::class.java)

            // Tambahkan kode di sini jika perlu meneruskan data melalui intent
            // Contoh: intent.putExtra("KEY", value)

            // Mulai DetailGrafikActivity
            startActivity(intent)
        }
    }
}

