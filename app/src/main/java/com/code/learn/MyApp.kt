package com.code.learn

import android.app.Application
import android.content.Context

class MyApp:Application() {
    init {
        instance = this
    }

    companion object {
        private lateinit var instance: MyApp

        fun getInstance(): MyApp {
            return instance
        }

        fun getContext(): Context {
            return instance.applicationContext
        }
    }
}