package br.com.kotlincoroutine.base

import android.app.Application
import br.com.kotlincoroutine.data.di.repositoryModule
import br.com.kotlincoroutine.domain.di.domainModule
import br.com.kotlincoroutine.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(presentationModule + domainModule + repositoryModule);
        }
    }
}