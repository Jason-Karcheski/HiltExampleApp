package com.jeisundev.hiltexampleapp.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.jeisundev.hiltexampleapp.databinding.ActivityExchangeRateBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * NOTE:
 * `@AndroidEntryPoint` tells Hilt we are injecting into this Activity
 */
@AndroidEntryPoint
class ExchangeRateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExchangeRateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExchangeRateBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}