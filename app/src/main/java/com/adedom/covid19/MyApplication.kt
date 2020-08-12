package com.adedom.covid19

import android.app.Application
import com.adedom.covid19.di.appModule
import com.adedom.covid19.di.dataStorageModule
import com.adedom.covid19.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule, dataStorageModule, networkModule)
        }
    }

}
