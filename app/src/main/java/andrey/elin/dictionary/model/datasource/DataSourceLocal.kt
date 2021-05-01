package andrey.elin.dictionary.model.datasource

import andrey.elin.dictionary.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}