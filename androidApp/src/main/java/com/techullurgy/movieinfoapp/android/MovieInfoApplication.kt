package com.techullurgy.movieinfoapp.android

import android.app.Application
import com.techullurgy.movieinfoapp.di.doStartKoin

class MovieInfoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        doStartKoin(this)
    }
}