package andrey.elin.dictionary.view.history

import andrey.elin.dictionary.model.data.AppState
import andrey.elin.dictionary.model.data.DataModel
import andrey.elin.dictionary.model.repository.Repository
import andrey.elin.dictionary.model.repository.RepositoryLocal
import andrey.elin.dictionary.viewmodel.Interactor

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