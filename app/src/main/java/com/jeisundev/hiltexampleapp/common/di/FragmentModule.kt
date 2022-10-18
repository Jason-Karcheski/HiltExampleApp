package com.jeisundev.hiltexampleapp.common.di

import com.jeisundev.hiltexampleapp.common.HiltExampleApplication
import com.jeisundev.hiltexampleapp.domain.repository.ExchangeRateRepository
import com.jeisundev.hiltexampleapp.presentation.ExchangeRateViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
class FragmentModule {

    /**
     * NOTE:
     * The parameters are used to pass in the dependencies needed to make this dependency.
     * Here we need an instance of HiltExampleApplication to make the viewModel.
     * To get that we need to:
     *   1) Define how to create an instance of HiltViewModel (in SingletonModule)
     *   2) Pass it as a parameter here
     *   3) Use that parameter to create the instance of the viewModel
     *
     * Also, when we pass in the repository we use the interface type, not the implementation.
     * This is so that when we write tests later on we can pass in a test implementation instead of the real thing.
     * This test implementation will also implement the repository interface and as a result will work in our code for testing.
     */
    @Provides
    @FragmentScoped
    fun providesExchangeRateViewModel(
        app: HiltExampleApplication,
        repo: ExchangeRateRepository
    ) : ExchangeRateViewModel {
        return ExchangeRateViewModel(app, repo)
    }

}