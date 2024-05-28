package com.dicoding.tesya.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dicoding.tesya.R
import com.dicoding.tesya.databinding.FragmentOnboardingBinding


class OnboardingFragment1 : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tampilkan tulisan di TextView atau elemen UI lainnya
        binding.imageViewOnboarding.setImageResource(R.drawable.onboarding1)
        binding.textViewTitle.text = getString(R.string.onboard1)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}