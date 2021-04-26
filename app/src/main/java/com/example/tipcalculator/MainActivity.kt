package com.example.tipcalculator

import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.edit_text)
        val output = findViewById<TextView>(R.id.text_view)
        val slider = findViewById<Slider>(R.id.slider)

        fun tipCalculate () {
            val tipAmount = input.text.toString().toDouble() * slider.value.toString().toDouble() / 100
            val tipAmountFormated = String.format("%.2f", tipAmount)
            output.text = getString(R.string.tip_amount) + tipAmountFormated
        }

        slider.addOnChangeListener { _, value, _ ->
            if (input.length() != 0) tipCalculate()
        }

        input.doAfterTextChanged { text: Editable? ->
            if (text?.length != 0) tipCalculate() else output.text = ""
        }
    }
}