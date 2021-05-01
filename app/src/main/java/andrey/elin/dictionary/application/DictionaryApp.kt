package andrey.elin.dictionary.application

import andrey.elin.dictionary.di.application
import andrey.elin.dictionary.di.historyScreen
import andrey.elin.dictionary.di.mainScreen
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class DictionaryApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }
}