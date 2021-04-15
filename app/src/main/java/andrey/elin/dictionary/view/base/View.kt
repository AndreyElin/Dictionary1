package andrey.elin.dictionary.view.base

import andrey.elin.dictionary.model.data.AppState

interface View {

    fun renderData(appState: AppState)

}
