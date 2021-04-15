package andrey.elin.dictionary.model.repository

import andrey.elin.dictionary.model.data.DataModel
import andrey.elin.dictionary.model.datasource.DataSource
import andrey.elin.dictionary.model.repository.Repository
import io.reactivex.Observable

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}
