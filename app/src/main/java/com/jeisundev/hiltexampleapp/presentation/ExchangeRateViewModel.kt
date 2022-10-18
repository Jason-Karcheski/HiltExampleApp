package com.jeisundev.hiltexampleapp.presentation

import androidx.lifecycle.AndroidViewModel
import com.jeisundev.hiltexampleapp.common.HiltExampleApplication
import com.jeisundev.hiltexampleapp.data.models.ExchangeRate
import com.jeisundev.hiltexampleapp.domain.repository.ExchangeRateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * NOTE:
 * `@HiltViewModel` - Tells the Hilt compiler that we will be injecting dependencies here
 * `@Inject` - Unsurprisingly, this is used to inject something, here we inject the constructor.
 *
 * This code will get the value of the constructor parameters from the methods defined in the modules.
 */
@HiltViewModel
class ExchangeRateViewModel @Inject constructor(
    app: HiltExampleApplication,
    private val repo: ExchangeRateRepository
) : AndroidViewModel(app) {

    fun getRates() : Observable<ExchangeRate> {
        return repo.getRates()
    }

}