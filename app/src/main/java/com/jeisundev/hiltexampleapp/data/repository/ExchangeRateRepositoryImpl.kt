package com.jeisundev.hiltexampleapp.data.repository

import com.jeisundev.hiltexampleapp.data.ExchangeRateApi
import com.jeisundev.hiltexampleapp.data.models.ExchangeRate
import com.jeisundev.hiltexampleapp.domain.repository.ExchangeRateRepository
import io.reactivex.rxjava3.core.Observable

class ExchangeRateRepositoryImpl(
    private val api: ExchangeRateApi
) : ExchangeRateRepository {

    /**
     * NOTE:
     * Here we would usually do:
     *   return api.getRates()
     * However, I am just going to return some dummy data because there is no backend in reality.
     */
    override fun getRates(): Observable<ExchangeRate> {
        return Observable.just(ExchangeRate("GBP", "USD", 1.13))
    }

}