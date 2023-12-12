package com.techullurgy.movieinfoapp.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

fun doStartKoin(application: Application) {
    startKoin {
        androidContext(application)
        modules(appModule())
    }
}