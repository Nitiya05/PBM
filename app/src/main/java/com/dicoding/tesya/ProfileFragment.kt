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

        // Initialize Firebase Authentication
        auth = FirebaseAuth.getInstance()

        // Load user profile
        loadUserProfile()

        // Set onClickListener for Edit Profile button
        binding.btnEditProfil.setOnClickListener {
            startActivity(Intent(context, EditProfileActivity::class.java))
        }

        // Set onClickListener for Logout button
        binding.btnLogout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(context, LoginActivity::class.java))
            activity?.finish()
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        loadUserProfile()
    }

    private fun loadUserProfile() {
        val currentUser = auth.currentUser
        currentUser?.let {
            val nama = it.displayName
            if (!nama.isNullOrEmpty()) {
                binding.tvUserName.text = nama
            }

            val email = it.email
            if (!email.isNullOrEmpty()) {
                binding.tvEmail.text = email
            }

            val password = "******" // You may not have access to the user's password, so use a placeholder
            binding.tvAlamat.text = password
        }
    }
}
