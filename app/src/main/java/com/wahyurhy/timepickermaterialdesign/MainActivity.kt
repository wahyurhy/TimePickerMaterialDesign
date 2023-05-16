package com.wahyurhy.timepickermaterialdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat.is24HourFormat
import android.util.Log
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.wahyurhy.timepickermaterialdesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            openTimePicker()
        }
    }

    private fun openTimePicker() {
        val isSystem24Hour = is24HourFormat(this)
        val clockFormat = if (isSystem24Hour) TimeFormat.CLOCK_12H else TimeFormat.CLOCK_12H

        val picker = MaterialTimePicker.Builder()
            .setTimeFormat(clockFormat)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Set Alarm")
            .build()
        picker.show(supportFragmentManager, "TAG") // when using fragment, you can use "childFragmentManager" as the fragmentManager

        picker.addOnPositiveButtonClickListener {
            Log.d("MainActivity", "Positive")
            val h = picker.hour
            val min = picker.minute
            Log.d("MainActivity", "$h:$min")
        }

        picker.addOnNegativeButtonClickListener {
            Log.d("MainActivity", "Negative")
        }

        picker.addOnCancelListener {
            Log.d("MainActivity", "Cancel")
        }

        picker.addOnDismissListener {
            Log.d("MainActivity", "Dismiss")
        }
    }
}