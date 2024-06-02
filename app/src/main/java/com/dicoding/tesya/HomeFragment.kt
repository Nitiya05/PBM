package com.dicoding.tesya

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dicoding.tesya.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi Firebase Authentication
        auth = FirebaseAuth.getInstance()

        // Mendapatkan pengguna saat ini
        val currentUser = auth.currentUser

        // Set teks TextView tv_username dengan nama pengguna jika pengguna telah masuk
        currentUser?.let {
            val username = currentUser.displayName
            if (!username.isNullOrEmpty()) {
                binding.tvUsername.text = username
            }
        }

        // Atur onClickListener untuk ImageButton ib_notif
        binding.ibNotif.setOnClickListener {
            // Ketika ImageButton di klik, arahkan ke NotificationActivity
            val intent = Intent(requireContext(), NotificationActivity::class.java)
            startActivity(intent)
        }
    }
}
