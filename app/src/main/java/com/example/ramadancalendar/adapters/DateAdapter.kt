package com.example.ramadancalendar.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.example.ramadancalendar.R
import com.example.ramadancalendar.databinding.LayoutCalendarCellBinding
import com.example.ramadancalendar.model.DateModel
import com.example.ramadancalendar.utility.Utils

class DateAdapter(
    private val context: Context,
    private val dates: List<DateModel>
) :
    BaseAdapter() {
    override fun getCount(): Int {
        return dates.size
    }

    override fun getItem(position: Int): Any {
        return dates[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: LayoutCalendarCellBinding = if (convertView == null) {
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.layout_calendar_cell, null, false
            )
        } else {
            convertView.tag as LayoutCalendarCellBinding
        }



        binding.tvRamadanNum.text = dates[position].num
        binding.tvDate.text = context.resources.getString(
            R.string.todays_date,
            Utils().toBanglaDigit(dates[position].date.dayOfMonth),
            Utils().toBanglaMonth(dates[position].date.month.toString()),
            Utils().toBanglaDayOfWeek(dates[position].date.dayOfWeek.toString())
        )
        binding.tvSuhoorTime.text = Utils().toBanglaTime(dates[position].sehriTime.toString())
        binding.tvIftarTime.text = Utils().toBanglaTime(dates[position].iftarTime.toString())

        binding.root.tag = binding
        return binding.root
    }


    interface SelectDateListener {
        fun onDateSelected(position: Int, date: String)
    }

}
