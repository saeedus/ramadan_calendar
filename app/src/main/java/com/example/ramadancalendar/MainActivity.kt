package com.example.ramadancalendar

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.ramadancalendar.R
import com.example.ramadancalendar.adapters.DateAdapter
import com.example.ramadancalendar.databinding.ActivityMainBinding
import com.example.ramadancalendar.model.DateModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Prepare your data list here (replace with actual data)
        val data = ArrayList<DateModel>()
        for (i in 1..30) {
            val model = DateModel(i.toString())
            data.add(model)
        }

        val gridView = binding.gvCalendar
        val adapter = DateAdapter(this, data)
        gridView.adapter = adapter
    }
}

