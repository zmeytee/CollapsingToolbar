package ru.zmeytee.myapplication

import android.app.Application
import android.util.Log

class App: Application() {

    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        const val TAG = "ApplicationTAG"
    }

}