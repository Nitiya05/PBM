package com.dicoding.tesya

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dicoding.tesya.databinding.FragmentProfileBinding
import com.dicoding.tesya.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        // Inisialisasi Firebase Authentication
        auth = FirebaseAuth.getInstance()

        // Mendapatkan pengguna saat ini
        val currentUser = auth.currentUser

        // Set teks TextView tv_nama dengan nama pengguna jika pengguna telah masuk
        currentUser?.let {
            val nama = currentUser.displayName
            if (!nama.isNullOrEmpty()) {
                binding.tvUserName.text = nama
            }

            // Set teks TextView tv_email dengan email pengguna
            val email = currentUser.email
            if (!email.isNullOrEmpty()) {
                binding.tvEmail.text = email
            }

            // Set teks TextView tv_alamat dengan password pengguna
            val password = "******" // Anda mungkin tidak dapat mengakses password pengguna, jadi gunakan placeholder
            binding.tvPasswordd.text = password
        }

        // Tambahkan onClickListener pada tombol "Edit Profile" untuk mengarahkan ke halaman edit profil
        binding.btnEditProfil.setOnClickListener {
            startActivity(Intent(context, EditProfileActivity::class.java))
        }

        // Tambahkan onClickListener pada tombol "Keluar" untuk logout
        binding.btnLogout.setOnClickListener {
            // Logout pengguna
            auth.signOut()

            // Redirect ke halaman login
            startActivity(Intent(context, LoginActivity::class.java))
            activity?.finish()
        }

        return view
    }
}
