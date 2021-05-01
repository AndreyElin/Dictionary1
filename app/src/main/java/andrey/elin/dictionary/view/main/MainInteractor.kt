package andrey.elin.dictionary.view.main

import andrey.elin.dictionary.model.data.AppState
import andrey.elin.dictionary.model.data.DataModel
import andrey.elin.dictionary.model.repository.Repository
import andrey.elin.dictionary.model.repository.RepositoryLocal
import andrey.elin.dictionary.viewmodel.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(repositoryLocal.getData(word))
        }
        return appState
    }
}
