package andrey.elin.dictionary.application

import andrey.elin.dictionary.di.AppComponent
import andrey.elin.dictionary.di.DaggerAppComponent
import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class DictionaryApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val component = DaggerAppComponent.builder().appContent(this).build()
        DictionaryApp.component = component
    }

    companion object {
        lateinit var component: AppComponent
    }
}