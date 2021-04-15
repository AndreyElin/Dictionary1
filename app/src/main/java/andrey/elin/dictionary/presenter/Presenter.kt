package andrey.elin.dictionary.presenter

import andrey.elin.dictionary.model.data.AppState
import andrey.elin.dictionary.view.base.View

interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}
