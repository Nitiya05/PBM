package com.dicoding.tesya

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.dicoding.tesya.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val currentUser = auth.currentUser
        val editTextName = binding.editTextName
        val etPasswordLogin = binding.etPasswordLogin

        currentUser?.let { user ->
            editTextName.setText(user.displayName)
            etPasswordLogin.setText("******") // Placeholder for password
        }

        binding.btnSave.setOnClickListener {
            val newName = editTextName.text.toString()
            val newPassword = etPasswordLogin.text.toString()

            currentUser?.let { user ->
                val profileUpdates = UserProfileChangeRequest.Builder()
                    .setDisplayName(newName)
                    .build()

                user.updateProfile(profileUpdates).addOnCompleteListener { profileTask ->
                    if (profileTask.isSuccessful) {
                        if (newPassword != "******") {
                            user.updatePassword(newPassword).addOnCompleteListener { passwordTask ->
                                if (passwordTask.isSuccessful) {
                                    Toast.makeText(
                                        this,
                                        "Profile updated successfully.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    // Redirect back to ProfileFragment
                                    setResult(RESULT_OK)
                                    finish()
                                } else {
                                    Toast.makeText(
                                        this,
                                        "Failed to update password.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        } else {
                            Toast.makeText(
                                this,
                                "Profile updated successfully.",
                                Toast.LENGTH_SHORT
                            ).show()
                            // Redirect back to ProfileFragment
                            setResult(RESULT_OK)
                            finish()
                        }
                    } else {
                        Toast.makeText(
                            this,
                            "Failed to update profile.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }
    }
}

