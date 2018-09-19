package ez.invoice.jason.themegenerator

import android.view.View
import android.widget.EditText
import android.widget.TextView
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.junit.Assert.*
import org.junit.Before

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    private lateinit var mainActivity: MainActivity

    @Before
    fun initTest() {
        mainActivity = Robolectric.setupActivity(MainActivity::class.java)
    }

    @Test
    fun mainActivityStart() {

        val preview = mainActivity.findViewById<View>(R.id.activity_main_preview).isShown
        assertTrue(preview)
    }

    @Test
    fun mainActivityStartWithDefaultThemeValues() {

        val primaryColor = mainActivity.findViewById<EditText>(R.id.activity_main_primary_color_edt).text.toString().trim()
        assertEquals("#00aeef", primaryColor)

        val primaryColorLight = mainActivity.findViewById<EditText>(R.id.activity_main_primary_color_light_edt).text.toString().trim()
        assertEquals("#d7f2fc", primaryColorLight)

        val primaryColorDark = mainActivity.findViewById<EditText>(R.id.activity_main_primary_color_dark_edt).text.toString().trim()
        assertEquals("#d7f2fc", primaryColorDark)

        val primaryBlack = mainActivity.findViewById<EditText>(R.id.activity_main_primary_black_edt).text.toString().trim()
        assertEquals("#37474f", primaryBlack)
    }

}