package andrey.elin.dictionary.di

import andrey.elin.dictionary.application.DictionaryApp
import andrey.elin.dictionary.view.main.MainActivity
import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        InteractorModule::class,
        RepositoryModule::class,
        ViewModelModule::class
    ]
)
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appContent(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(activity: MainActivity)
}