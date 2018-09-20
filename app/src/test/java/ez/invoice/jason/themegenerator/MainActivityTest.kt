package ez.invoice.jason.themegenerator

import android.graphics.Color
import android.view.View
import android.view.View.VISIBLE
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
    private lateinit var primaryText: TextView
    private lateinit var primaryLightText: TextView
    private lateinit var primaryDarkText: TextView
    private lateinit var primaryBlackText: TextView
    private lateinit var primaryEdt: EditText
    private lateinit var primaryLightEdt: EditText
    private lateinit var primaryDarkEdt: EditText
    private lateinit var primaryBlackEdt: EditText

    @Before
    fun setupTest() {
        mainActivity = Robolectric.buildActivity(MainActivity::class.java).create().get()
        primaryText = mainActivity.findViewById(R.id.activity_main_primary_color)
        primaryLightText = mainActivity.findViewById(R.id.activity_main_primary_color_light)
        primaryDarkText = mainActivity.findViewById(R.id.activity_main_primary_color_dark)
        primaryBlackText = mainActivity.findViewById(R.id.activity_main_primary_black)
        primaryEdt = mainActivity.findViewById(R.id.activity_main_primary_color_edt)
        primaryLightEdt = mainActivity.findViewById(R.id.activity_main_primary_color_light_edt)
        primaryDarkEdt = mainActivity.findViewById(R.id.activity_main_primary_color_dark_edt)
        primaryBlackEdt = mainActivity.findViewById(R.id.activity_main_primary_black_edt)
    }

    @Test
    fun mainActivityStart() {
        val preview = mainActivity.findViewById<View>(R.id.activity_main_preview)
        assertTrue(preview.visibility == VISIBLE)
    }

    @Test
    fun start_view_with_default_theme_values() {

        val primaryColor = primaryEdt.text.toString().trim()
        assertEquals("00aeef", primaryColor)

        val primaryColorLight = primaryLightEdt.text.toString().trim()
        assertEquals("d7f2fc", primaryColorLight)

        val primaryColorDark = primaryDarkEdt.text.toString().trim()
        assertEquals("d7f2fc", primaryColorDark)

        val primaryBlack = primaryBlackEdt.text.toString().trim()
        assertEquals("37474f", primaryBlack)
    }

    @Test
    fun textView_color_should_change_when_valid_colorHex_is_input() {

        primaryEdt.setText("b5c7d5")
        primaryLightEdt.setText("526b7a")
        primaryDarkEdt.setText("293641")
        primaryBlackEdt.setText("0d1114")

        val primaryColor = primaryText.currentTextColor
        val primaryLightColor = primaryLightText.currentTextColor
        val primaryDarkColor = primaryDarkText.currentTextColor
        val primaryBlackColor = primaryBlackText.currentTextColor

        assertEquals(Color.parseColor("#b5c7d5"), primaryColor)
        assertEquals(Color.parseColor("#526b7a"), primaryLightColor)
        assertEquals(Color.parseColor("#293641"), primaryDarkColor)
        assertEquals(Color.parseColor("#0d1114"), primaryBlackColor)

    }

}