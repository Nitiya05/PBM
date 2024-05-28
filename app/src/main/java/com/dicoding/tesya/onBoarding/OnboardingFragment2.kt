package com.dicoding.tesya.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dicoding.tesya.R
import com.dicoding.tesya.databinding.FragmentOnboardingBinding

class OnboardingFragment2 : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageViewOnboarding.setImageResource(R.drawable.onboarding2)
        binding.textViewTitle.text = getString(R.string.onboard2)

    }
}