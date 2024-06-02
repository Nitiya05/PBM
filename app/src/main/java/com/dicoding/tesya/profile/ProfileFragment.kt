package com.dicoding.tesya.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.dicoding.tesya.databinding.FragmentProfileBinding
import com.dicoding.tesya.login.LoginActivity

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser

        currentUser?.let { user ->
            // Update UI with user data
            binding.tvUserName.text = user.displayName
            binding.tvEmail.text = user.email
        }

        binding.btnEditProfil.setOnClickListener {
            val intent = Intent(activity, EditProfileActivity::class.java)
            startActivityForResult(intent, EDIT_PROFILE_REQUEST)
        }

        binding.btnLogout.setOnClickListener {
            auth.signOut()
            // Redirect to Login activity
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }

    companion object {
        private const val EDIT_PROFILE_REQUEST = 1
    }
}



