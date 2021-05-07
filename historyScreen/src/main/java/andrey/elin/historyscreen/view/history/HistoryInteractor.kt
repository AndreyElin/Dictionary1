package andrey.elin.historyscreen.view.history

import andrey.elin.model.data.AppState
import andrey.elin.model.data.DataModel
import andrey.elin.repository.Repository
import andrey.elin.repository.RepositoryLocal
import andrey.elin.core.viewmodel.Interactor

class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}