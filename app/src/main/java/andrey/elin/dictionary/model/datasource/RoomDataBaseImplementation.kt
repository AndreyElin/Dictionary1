package andrey.elin.dictionary.model.datasource

import andrey.elin.dictionary.model.data.DataModel
import andrey.elin.dictionary.model.datasource.DataSource
import io.reactivex.Observable

class RoomDataBaseImplementation : DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
