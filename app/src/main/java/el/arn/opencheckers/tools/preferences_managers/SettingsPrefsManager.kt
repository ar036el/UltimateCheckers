package el.arn.opencheckers.tools.preferences_managers

import android.content.Context
import android.content.SharedPreferences
import el.arn.opencheckers.appRoot

class SettingsPrefsManager : PrefsManager(sharedPreferences) {
    companion object {
        private val sharedPreferences: SharedPreferences
            get() = appRoot.getSharedPreferences("settings", Context.MODE_PRIVATE)
    }


    //Todo needs to make a factory from every instantiation...
    val isCustomSettingsEnabled = createBooleanPref("isCustomSettingsEnabled", false)
    val regularBoardSize = createIntPref("boardSize", setOf(8, 10, 12), 8)
    val customBoardSize = createIntPref("boardSize", 4..24 step 2, 8)
    val customStartingRows = createIntPref("boardSize", 1..11, 3)

}