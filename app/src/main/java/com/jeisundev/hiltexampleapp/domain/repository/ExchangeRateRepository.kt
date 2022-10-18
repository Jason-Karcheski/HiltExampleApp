package com.jeisundev.hiltexampleapp.domain.repository

import com.jeisundev.hiltexampleapp.data.models.ExchangeRate
import io.reactivex.rxjava3.core.Observable

interface ExchangeRateRepository {
    fun getRates() : Observable<ExchangeRate>
}