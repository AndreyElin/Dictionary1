package andrey.elin.repository

interface DataSource<T> {

    suspend fun getData(word: String): T
}
