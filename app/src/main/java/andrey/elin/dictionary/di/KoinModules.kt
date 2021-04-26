package andrey.elin.dictionary.di

import andrey.elin.dictionary.model.data.DataModel
import andrey.elin.dictionary.model.datasource.RetrofitImplementation
import andrey.elin.dictionary.model.datasource.RoomDataBaseImplementation
import andrey.elin.dictionary.model.repository.Repository
import andrey.elin.dictionary.model.repository.RepositoryImplementation
import andrey.elin.dictionary.view.main.MainInteractor
import andrey.elin.dictionary.view.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) { RepositoryImplementation(
        RetrofitImplementation()
    ) }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) { RepositoryImplementation(
        RoomDataBaseImplementation()
    ) }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    viewModel { MainViewModel(get()) }
}