package com.tekydevelop.radixfm

import android.app.Application
import com.tekydevelop.data.di.apiModule
import com.tekydevelop.data.di.dbModule
import com.tekydevelop.domain.di.domainModule
import com.tekydevelop.radixfm.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, domainModule, apiModule, dbModule))
        }
    }
}