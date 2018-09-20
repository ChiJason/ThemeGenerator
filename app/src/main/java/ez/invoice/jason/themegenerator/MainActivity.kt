package ez.invoice.jason.themegenerator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val primaryColor by lazy { activity_main_primary_color_edt }
    private val primaryColorLight by lazy { activity_main_primary_color_light_edt }
    private val primaryColorDark by lazy { activity_main_primary_color_dark_edt }
    private val primaryBlack by lazy { activity_main_primary_black_edt }
    private val primaryColorText by lazy { activity_main_primary_color }
    private val primaryColorLightText by lazy { activity_main_primary_color_light }
    private val primaryColorDarkText by lazy { activity_main_primary_color_dark }
    private val primaryBlackText by lazy { activity_main_primary_black }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        setupListener()
    }

    private fun setupView() {
        primaryColor.setText("00aeef")
        primaryColorLight.setText("d7f2fc")
        primaryColorDark.setText("d7f2fc")
        primaryBlack.setText("37474f")
    }

    private fun setupListener() {

    }

}
