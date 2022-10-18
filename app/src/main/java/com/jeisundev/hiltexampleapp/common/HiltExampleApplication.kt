package com.jeisundev.hiltexampleapp.common

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * NOTE:
 * When we use Hilt we have to have an application class annotated with @HiltAndroidApp.
 * Hilt needs this to know what application class it should use as a context to generate our dependencies.
 */
@HiltAndroidApp
class HiltExampleApplication : Application()