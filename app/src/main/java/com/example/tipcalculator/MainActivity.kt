package com.example.tipcalculator

import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.slider.Slider
import java.util.*

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

            val str = readLine()!!.toString()
            val n = readLine()!!.toInt()

            print("Symbol # 1 of the string \" $str \" is '${str[n - 1]}'")
            str[str.length - 1]


            val c1 = (readLine()!!.split(" ").map { it.toInt() }).toList().sortedDescending()
            val c2 = (readLine()!!.split(" ").map { it.toInt() }).toList().sortedDescending()

            if (c1 == c2) print("Box 1 = Box 2")
            if (c1[0] >= c2[0]) {
                if (c1[1] >= c2[1]) {
                    if (c1[2] >= c2[2]) print("Box 1 > Box 2")
                    else print("Incomparable")
                }
                else print("Incomparable")
            }
            else {
                if (c1[1] <= c2[1] && c1[0] <= c2[0]) print("Box 1 < Box 2")
                else print("Incomparable")
            }

            val (a, b, h) = Array<Int>(3) { readLine()!!.toInt()}

        }
    }
}