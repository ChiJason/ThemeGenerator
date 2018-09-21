package ez.invoice.jason.themegenerator

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import android.view.View
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.junit.Assert.*
import org.junit.Before
import org.robolectric.shadows.ShadowToast

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    private lateinit var mainActivity: MainActivity
    private lateinit var viewModel: MainViewModel
    private lateinit var primaryText: TextView
    private lateinit var primaryLightText: TextView
    private lateinit var primaryDarkText: TextView
    private lateinit var primaryBlackText: TextView
    private lateinit var primaryEdt: EditText
    private lateinit var primaryLightEdt: EditText
    private lateinit var primaryDarkEdt: EditText
    private lateinit var primaryBlackEdt: EditText
    private lateinit var invoiceNo: TextView
    private lateinit var invoiceCircle: TextView
    private lateinit var invoiceGotPrice: TextView
    private lateinit var invoiceMoney: TextView

    private var primary = "00aeef"
    private var light = "d7f2fc"
    private var dark = "007fbc"
    private var black = "37474f"

    @Before
    fun setupTest() {
        mainActivity = Robolectric.buildActivity(MainActivity::class.java).create().get()
        viewModel = ViewModelProviders.of(mainActivity).get(MainViewModel::class.java)
        primaryText = mainActivity.findViewById(R.id.activity_main_primary_color)
        primaryLightText = mainActivity.findViewById(R.id.activity_main_primary_color_light)
        primaryDarkText = mainActivity.findViewById(R.id.activity_main_primary_color_dark)
        primaryBlackText = mainActivity.findViewById(R.id.activity_main_primary_black)
        primaryEdt = mainActivity.findViewById(R.id.activity_main_primary_color_edt)
        primaryLightEdt = mainActivity.findViewById(R.id.activity_main_primary_color_light_edt)
        primaryDarkEdt = mainActivity.findViewById(R.id.activity_main_primary_color_dark_edt)
        primaryBlackEdt = mainActivity.findViewById(R.id.activity_main_primary_black_edt)
        invoiceNo = mainActivity.findViewById(R.id.invoice_no)
        invoiceCircle = mainActivity.findViewById(R.id.invoice_circle)
        invoiceGotPrice = mainActivity.findViewById(R.id.invoice_got_prize)
        invoiceMoney = mainActivity.findViewById(R.id.invoice_money)
    }

    @Test
    fun mainActivityStart() {
        val preview = mainActivity.findViewById<View>(R.id.activity_main_preview)
        assertTrue(preview.visibility == VISIBLE)
    }

    @Test
    fun start_view_with_default_theme_values() {

        val primaryColor = primaryText.currentTextColor
        val primaryLightColor = primaryLightText.currentTextColor
        val primaryDarkColor = primaryDarkText.currentTextColor
        val primaryBlackColor = primaryBlackText.currentTextColor
        val invoiceNoColor = invoiceNo.currentTextColor
        val invoiceCircleTextColor = invoiceCircle.currentTextColor
        val invoiceMoneyColor = invoiceMoney.currentTextColor

        assertEquals(Color.parseColor("#$primary"), primaryColor)
        assertEquals(Color.parseColor("#$light"), primaryLightColor)
        assertEquals(Color.parseColor("#$dark"), primaryDarkColor)
        assertEquals(Color.parseColor("#$black"), primaryBlackColor)
        assertEquals(Color.parseColor("#$black"), invoiceNoColor)
        assertEquals(Color.parseColor("#$primary"), invoiceCircleTextColor)
        assertEquals(Color.parseColor("#$dark"), invoiceMoneyColor)

    }

    @Test
    fun textView_color_should_change_when_valid_colorHex_is_input() {

        primary = "b5c7d5"
        light = "526b7a"
        dark = "293641"
        black = "0d1114"

        primaryEdt.setText(primary)
        primaryLightEdt.setText(light)
        primaryDarkEdt.setText(dark)
        primaryBlackEdt.setText(black)

        val primaryColor = primaryText.currentTextColor
        val primaryLightColor = primaryLightText.currentTextColor
        val primaryDarkColor = primaryDarkText.currentTextColor
        val primaryBlackColor = primaryBlackText.currentTextColor
        val invoiceNoColor = invoiceNo.currentTextColor
        val invoiceCircleTextColor = invoiceCircle.currentTextColor
        val invoiceMoneyColor = invoiceMoney.currentTextColor

        assertEquals(Color.parseColor("#$primary"), primaryColor)
        assertEquals(Color.parseColor("#$light"), primaryLightColor)
        assertEquals(Color.parseColor("#$dark"), primaryDarkColor)
        assertEquals(Color.parseColor("#$black"), primaryBlackColor)
        assertEquals(Color.parseColor("#$black"), invoiceNoColor)
        assertEquals(Color.parseColor("#$primary"), invoiceCircleTextColor)
        assertEquals(Color.parseColor("#$dark"), invoiceMoneyColor)
    }

    @Test
    fun show_toast_when_color_hex_is_not_valid() {

        val expected = "color hex is invalid"

        primary = "b5c7d$"
        primaryEdt.setText(primary)
        assertEquals(expected, ShadowToast.getTextOfLatestToast())

        light = "526b7$"
        primaryLightEdt.setText(light)
        assertEquals(expected, ShadowToast.getTextOfLatestToast())

        dark = "29364$"
        primaryDarkEdt.setText(dark)
        assertEquals(expected, ShadowToast.getTextOfLatestToast())

        black = "0d111$"
        primaryBlackEdt.setText(black)
        assertEquals(expected, ShadowToast.getTextOfLatestToast())
    }

    @Test
    fun clear_all_editText_when_clear_button_is_clicked() {
        val expected = ""

        mainActivity.findViewById<Button>(R.id.activity_main_clear_btn).performClick()

        assertEquals(expected, primaryEdt.text.toString().trim())
        assertEquals(expected, primaryLightEdt.text.toString().trim())
        assertEquals(expected, primaryDarkEdt.text.toString().trim())
        assertEquals(expected, primaryBlackEdt.text.toString().trim())
    }

    @Test
    fun create_theme_json_file_when_save_button_is_clicked() {

        val primaryColor = primaryEdt.text.toString().trim()
        val primaryLightColor = primaryLightEdt.text.toString().trim()
        val primaryDarkColor = primaryDarkEdt.text.toString().trim()
        val primaryBlack = primaryBlackEdt.text.toString().trim()

        val themeJson = "{ \"themeMedium\":\"$primaryColor\", " +
                "\"themeLight\":\"$primaryLightColor\", " +
                "\"themeDark\":\"$primaryDarkColor\", " +
                "\"primaryBlack\":\"$primaryBlack\" }"

        mainActivity.findViewById<Button>(R.id.activity_main_save_btn).performClick()
        assertEquals(themeJson, viewModel.getJsonString().value)
    }

}