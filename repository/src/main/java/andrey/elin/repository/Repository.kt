package andrey.elin.repository

interface Repository<T> {

    suspend fun getData(word: String): T
}
