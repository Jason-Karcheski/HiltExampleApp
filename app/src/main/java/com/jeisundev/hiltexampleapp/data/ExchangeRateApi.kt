package com.jeisundev.hiltexampleapp.data

import com.jeisundev.hiltexampleapp.data.models.ExchangeRate
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

/**
 * This isn't used in this project, just here to show you how to inject it as most projects would have one of these.
 */
interface ExchangeRateApi {

    @GET("/rates")
    fun getRates() : Observable<ExchangeRate>

}