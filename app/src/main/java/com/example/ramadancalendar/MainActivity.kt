package com.example.ramadancalendar

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ramadancalendar.adapters.DateAdapter
import com.example.ramadancalendar.databinding.ActivityMainBinding
import com.example.ramadancalendar.utility.Utils
import com.example.ramadancalendar.view_model.CalendarViewModel
import java.time.LocalTime


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var calendarViewModel: CalendarViewModel
    private lateinit var updateTimeHandler: Handler
    private lateinit var updateTimeRunnable: Runnable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        init()
    }

    override fun onPause() {
        super.onPause()
        updateTimeHandler.removeCallbacks(updateTimeRunnable)
    }

    override fun onResume() {
        super.onResume()
        updateTimeHandler.post(updateTimeRunnable)
    }

    private fun init() {
        calendarViewModel = ViewModelProvider(this)[CalendarViewModel::class.java]

        calendarViewModel.getRamadanDates().observe(this) { dateList ->
            val adapter = DateAdapter(this, dateList)
            binding.lvCalendar.adapter = adapter
        }

        updateIftarTime()

        updateTimeHandler = Handler(mainLooper)
        updateTimeRunnable = object : Runnable {
            override fun run() {
                updateIftarTime()
                updateTimeHandler.postDelayed(this, 1000)
            }
        }

        updateTimeHandler.post(updateTimeRunnable)
    }


    private fun updateIftarTime() {
        val iftarTime = calendarViewModel.getTodaysIftarTime()
        val sehriTime = calendarViewModel.getTodaysSehriTime()
        val currentTime = LocalTime.now()

        if (currentTime.isBefore(sehriTime)) {
            binding.tvTimeRemaining.text =
                getString(R.string.sehri_time_remaining, Utils().calculateRemainingTime(sehriTime))
        } else if (currentTime.isBefore(iftarTime)) {
            binding.tvTimeRemaining.text =
                getString(R.string.iftar_time_remaining, Utils().calculateRemainingTime(iftarTime))
        }
    }
}

