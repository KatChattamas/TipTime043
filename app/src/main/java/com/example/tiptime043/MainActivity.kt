package com.example.tiptime043

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tiptime043.databinding.ActivityMainBinding
import java.text.NumberFormat


class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculatorButton.setOnClickListener{calator_tip()}
    }

    fun calator_tip() {
        val stringintextField = binding.costOfServie.text.toString()
        val cost = stringintextField.toDouble()
        val selectedId = binding.tipOption.checkedRadioButtonId
        val tipPercentage = when (selectedId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        var roundUp = binding.roundUpSwitch.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}