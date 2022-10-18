package com.jeisundev.hiltexampleapp.common.di

import com.jeisundev.hiltexampleapp.common.HiltExampleApplication
import com.jeisundev.hiltexampleapp.data.ExchangeRateApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

/**
 * NOTE:
 * `@Module` - Defines this class as a Hilt Module.
 * `@InstallIn` - Scopes the module - in this case to SingletonComponent (scoped to the application).
 * SingletonComponent - The scope, this means we will only ever have one instance of SingletonModule in our apps lifetime
 */
@Module
@InstallIn(SingletonComponent::class)
class SingletonModule {

    /**
     * NOTE:
     * `@Provides` is used to declare a method will return a dependency.
     * `@Singleton` is used to ensure that we only ever create one instance of the dependency.
     * The return type of the method lets Hilt know what dependency this method is responsible for creating.
     *
     * The application class is a good candidate to put into the Singleton module as we only ever want one instance of it.
     *
     * Docs: https://developer.android.com/training/dependency-injection/hilt-android#inject-provides
     */
    @Provides
    @Singleton
    fun providesApplication() : HiltExampleApplication {
        return HiltExampleApplication()
    }

    /**
     * NOTE:
     * Same deal here. We only want one instance of our Api in the app.
     * So we tell Hilt how to provide (`@Provides`) a single instance (`@Singleton').
     */
    @Provides
    @Singleton
    fun provideApi() : ExchangeRateApi {
        return Retrofit.Builder()
            .baseUrl("https://thisIsAMock")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

}