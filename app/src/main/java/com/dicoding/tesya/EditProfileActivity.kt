package com.dicoding.tesya

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.dicoding.tesya.databinding.ActivityEditProfileBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase components
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference

        // Initialize views using binding
        val editTextName = binding.editTextName
        val etPasswordLogin = binding.etPasswordLogin
        val editTextAlamat = binding.editTextAlamat

        // Fetch current user
        val currentUser = auth.currentUser

        // Populate EditText fields with current user data
        currentUser?.let { user ->
            editTextName.setText(user.displayName)
            etPasswordLogin.setText("******") // You may not have access to the user's password, so use a placeholder
            // You can populate other fields here if needed
        }

        // Update button click listener
        binding.btnSave.setOnClickListener {
            val newName = editTextName.text.toString()
            val newPassword = etPasswordLogin.text.toString()

            // Update display name
            val profileUpdates = UserProfileChangeRequest.Builder()
                .setDisplayName(newName)
                .build()

            currentUser?.updateProfile(profileUpdates)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Update user data in Realtime Database (optional)
                        val userId = currentUser.uid
                        val userReference = database.child("users").child(userId)
                        userReference.child("fullName").setValue(newName)

                        Toast.makeText(
                            this,
                            "User profile updated successfully.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            this,
                            "Failed to update user profile.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            // Update password
            currentUser?.updatePassword(newPassword)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this,
                            "User password updated successfully.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            this,
                            "Failed to update user password.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }

        // Cancel button click listener
        binding.btnCancel.setOnClickListener {
            // Finish the activity without saving changes
            finish()
        }
    }
}



