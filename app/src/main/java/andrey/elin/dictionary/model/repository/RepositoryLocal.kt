package andrey.elin.dictionary.model.repository

import andrey.elin.dictionary.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}