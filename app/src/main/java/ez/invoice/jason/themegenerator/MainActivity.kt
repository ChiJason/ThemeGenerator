package ez.invoice.jason.themegenerator

import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.graphics.drawable.DrawableCompat
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
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
    private val invoiceNo by lazy { invoice_no }
    private val invoiceCircle by lazy { invoice_circle }
    private val invoiceMoney by lazy { invoice_money }
    private val clearBtn by lazy { activity_main_clear_btn }
    private val saveBtn by lazy { activity_main_save_btn }
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        setupView()
        setupListener()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
//        viewModel.getColorHexAvailable().observe(this, Observer {
//            available -> if (available == false) Toast.makeText(this, "color hex not valid", Toast.LENGTH_SHORT).show()
//        })
    }

    private fun setupView() {
        primaryColor.setText("00aeef")
        primaryColorText.setTextColor(Color.parseColor("#00aeef"))
        primaryColorLight.setText("d7f2fc")
        primaryColorLightText.setTextColor(Color.parseColor("#d7f2fc"))
        primaryColorDark.setText("007fbc")
        primaryColorDarkText.setTextColor(Color.parseColor("#007fbc"))
        primaryBlack.setText("37474f")
        primaryBlackText.setTextColor(Color.parseColor("#37474f"))
        invoiceNo.setTextColor(Color.parseColor("#37474f"))
        invoiceCircle.setTextColor(Color.parseColor("#00aeef"))
        DrawableCompat.setTint(DrawableCompat.wrap(invoiceCircle.background).mutate(),
                Color.parseColor("#d7f2fc"))
        invoiceMoney.setTextColor(Color.parseColor("#007fbc"))
    }

    private fun setupListener() {
        primaryColor.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
                if (text?.length == 6 || text?.length == 8) {
                    if (viewModel.checkColorHex("#$text")) {
                        primaryColorText.setTextColor(Color.parseColor("#$text"))
                        invoiceCircle.setTextColor(Color.parseColor("#$text"))
                    } else {
                        Toast.makeText(this@MainActivity, "color hex is invalid", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        primaryColorLight.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
                if (text?.length == 6 || text?.length == 8) {
                    if (viewModel.checkColorHex("#$text")) {
                        primaryColorLightText.setTextColor(Color.parseColor("#$text"))
                        DrawableCompat.setTint(DrawableCompat.wrap(invoiceCircle.background).mutate(),
                                Color.parseColor("#$text"))
                    } else {
                        Toast.makeText(this@MainActivity, "color hex is invalid", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        primaryColorDark.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
                if (text?.length == 6 || text?.length == 8) {
                    if (viewModel.checkColorHex("#$text")) {
                        primaryColorDarkText.setTextColor(Color.parseColor("#$text"))
                        invoiceMoney.setTextColor(Color.parseColor("#$text"))
                    } else {
                        Toast.makeText(this@MainActivity, "color hex is invalid", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        primaryBlack.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
                if (text?.length == 6 || text?.length == 8) {
                    if (viewModel.checkColorHex("#$text")) {
                        primaryBlackText.setTextColor(Color.parseColor("#$text"))
                        invoiceNo.setTextColor(Color.parseColor("#$text"))
                    } else {
                        Toast.makeText(this@MainActivity, "color hex is invalid", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        clearBtn.setOnClickListener {
            primaryColor.setText("")
            primaryColorLight.setText("")
            primaryColorDark.setText("")
            primaryBlack.setText("")
        }
        saveBtn.setOnClickListener {
            var themePack = ThemePack(
                    primaryColor.text.toString().trim(),
                    primaryColorLight.text.toString().trim(),
                    primaryColorDark.text.toString().trim(),
                    primaryBlack.text.toString().trim()
            )

            viewModel.createThemeJson(themePack)
        }
    }

}
