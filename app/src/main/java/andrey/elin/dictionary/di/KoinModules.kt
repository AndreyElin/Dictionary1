package andrey.elin.dictionary.di

import andrey.elin.dictionary.model.data.DataModel
import andrey.elin.dictionary.model.datasource.RetrofitImplementation
import andrey.elin.dictionary.model.datasource.RoomDataBaseImplementation
import andrey.elin.dictionary.model.repository.Repository
import andrey.elin.dictionary.model.repository.RepositoryImplementation
import andrey.elin.dictionary.model.repository.RepositoryImplementationLocal
import andrey.elin.dictionary.model.repository.RepositoryLocal
import andrey.elin.dictionary.room.HistoryDataBase
import andrey.elin.dictionary.view.history.HistoryInteractor
import andrey.elin.dictionary.view.history.HistoryViewModel
import andrey.elin.dictionary.view.main.MainInteractor
import andrey.elin.dictionary.view.main.MainViewModel
import androidx.room.Room
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(
        RetrofitImplementation()
    ) }
    single<RepositoryLocal<List<DataModel>>> { RepositoryImplementationLocal(
        RoomDataBaseImplementation(get())
    ) }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}