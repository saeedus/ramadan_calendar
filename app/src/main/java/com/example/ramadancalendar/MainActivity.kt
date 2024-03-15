package com.example.ramadancalendar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ramadancalendar.adapters.DateAdapter
import com.example.ramadancalendar.databinding.ActivityMainBinding
import com.example.ramadancalendar.model.DateModel
import com.example.ramadancalendar.view_model.CalendarViewModel
import java.util.Date


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

        calendarViewModel.getRamadanDate().observe(this) { dateList ->
            val adapter = DateAdapter(this, dateList)
            binding.lvCalendar.adapter = adapter
        }


    }
}

