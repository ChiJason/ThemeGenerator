package ez.invoice.jason.themegenerator

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.graphics.Color
import com.google.gson.Gson

class MainViewModel : ViewModel() {

    private val colorHexAvailable = MutableLiveData<Boolean>()
    private val jsonString = MutableLiveData<String>()

    fun getColorHexAvailable(): MutableLiveData<Boolean> {
        return colorHexAvailable
    }

    fun getJsonString(): MutableLiveData<String> {
        return jsonString
    }

    fun checkColorHex(textColor: String): Boolean{
        var isValid = true

        try {
            Color.parseColor(textColor)
        } catch (ex: Exception) {
            isValid = false
        }
        colorHexAvailable.value = isValid

        return isValid
    }

    fun createThemeJson(themePack: ThemePack) {
        jsonString.value = Gson().toJson(themePack)
    }

}