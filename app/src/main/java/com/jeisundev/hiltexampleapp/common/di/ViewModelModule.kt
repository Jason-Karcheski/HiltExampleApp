package com.jeisundev.hiltexampleapp.common.di

import com.jeisundev.hiltexampleapp.data.ExchangeRateApi
import com.jeisundev.hiltexampleapp.data.repository.ExchangeRateRepositoryImpl
import com.jeisundev.hiltexampleapp.domain.repository.ExchangeRateRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @Provides
    @ViewModelScoped
    fun providesExchangeRateRepository(api: ExchangeRateApi) : ExchangeRateRepository {
        return ExchangeRateRepositoryImpl(api)
    }

}