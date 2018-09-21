package ez.invoice.jason.themegenerator

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.graphics.Color

class MainViewModel : ViewModel() {

    private val colorHexAvailable = MutableLiveData<Boolean>()
    private val jsonString = MutableLiveData<String>()

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
}