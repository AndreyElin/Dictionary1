package andrey.elin.dictionary.model.datasource

import andrey.elin.dictionary.model.data.AppState
import andrey.elin.dictionary.model.data.DataModel
import andrey.elin.dictionary.room.HistoryDao
import andrey.elin.dictionary.utils.convertDataModelSuccessToEntity
import andrey.elin.dictionary.utils.mapHistoryEntityToSearchResult

class RoomDataBaseImplementation(private val historyDao: HistoryDao) : DataSourceLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}
