package com.example.ramadancalendar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ramadancalendar.adapters.DateAdapter
import com.example.ramadancalendar.databinding.ActivityMainBinding
import com.example.ramadancalendar.view_model.CalendarViewModel
import java.time.Duration
import java.time.LocalTime


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var calendarViewModel: CalendarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        init()
    }

    private fun init() {
        calendarViewModel = ViewModelProvider(this)[CalendarViewModel::class.java]

        calendarViewModel.getRamadanDates().observe(this) { dateList ->
            val adapter = DateAdapter(this, dateList)
            binding.lvCalendar.adapter = adapter
        }

        updateIftarTime()
    }


    private fun updateIftarTime() {
        val iftarTime = calendarViewModel.getTodaysIftarTime()
        val currentTime = LocalTime.now()

        val timeRemaining = if (currentTime.isBefore(iftarTime)) {
            Duration.between(currentTime, iftarTime).toMinutes()
        } else {
            val tomorrow = currentTime.plusHours(24)
            Duration.between(currentTime, tomorrow.with(iftarTime))
        }

        binding.tvTimeRemaining.text = resources.getString(R.string.iftar_time_remaining, timeRemaining)

    }
}

