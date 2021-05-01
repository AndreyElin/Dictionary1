package andrey.elin.dictionary.model.repository

import andrey.elin.dictionary.model.data.AppState
import andrey.elin.dictionary.model.data.DataModel
import andrey.elin.dictionary.model.datasource.DataSourceLocal

class RepositoryImplementationLocal(private val dataSource: DataSourceLocal<List<DataModel>>) :
    RepositoryLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}