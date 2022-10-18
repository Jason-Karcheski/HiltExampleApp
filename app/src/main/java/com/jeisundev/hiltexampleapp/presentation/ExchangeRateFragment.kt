package com.jeisundev.hiltexampleapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jeisundev.hiltexampleapp.R
import com.jeisundev.hiltexampleapp.data.models.ExchangeRate
import com.jeisundev.hiltexampleapp.databinding.FragmentExchangeRateBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

@AndroidEntryPoint
class ExchangeRateFragment : Fragment() {

    /**
     * NOTE:
     * Hilt is smart enough to inject a viewModel with the delegate we would usually use to get a viewModel.
     */
    private val viewModel: ExchangeRateViewModel by viewModels()
    private var _binding: FragmentExchangeRateBinding? = null
    private val binding: FragmentExchangeRateBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExchangeRateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            buttonGetRates.setOnClickListener {
                viewModel.getRates()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ response: ExchangeRate ->
                        text.text = """
                            From: ${response.from}
                            To: ${response.to}
                            Rate: ${response.rate}
                        """.trimIndent()
                    }, { error: Throwable ->
                        // I'm a lazy dev, hahaha
                    })
            }

            buttonClear.setOnClickListener {
                text.text = getString(R.string.app_name)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}