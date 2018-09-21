package ez.invoice.jason.themegenerator

import com.google.gson.annotations.SerializedName

class ThemePack (
        @SerializedName("themeMedium")
        var themeMedium: String,
        @SerializedName("themeLight")
        var themeLight: String,
        @SerializedName("themeDark")
        var themeDark: String,
        @SerializedName("primaryBlack")
        var primaryBlack: String
)