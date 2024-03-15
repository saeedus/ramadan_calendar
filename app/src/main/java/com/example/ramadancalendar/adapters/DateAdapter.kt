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
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DateAdapter(
    private val context: Context, private val dates: List<DateModel>
) : BaseAdapter() {
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

        binding.tvRamadanNum.text = Utils().toBanglaDigit(position + 1)
        binding.tvDate.text = context.resources.getString(
            R.string.todays_date,
            Utils().toBanglaDigit(dates[position].date.dayOfMonth),
            Utils().toBanglaMonth(dates[position].date.month.toString()),
            Utils().toBanglaDayOfWeek(dates[position].date.dayOfWeek.toString())
        )
        binding.tvSuhoorTime.text = Utils().toBanglaTime(
            dates[position].sehriTime.format(
                DateTimeFormatter.ofPattern("h:mm")
            )
        )
        binding.tvIftarTime.text =
            Utils().toBanglaTime(dates[position].iftarTime.format(DateTimeFormatter.ofPattern("h:mm")))

        highlightToday(binding, position)


        binding.root.tag = binding
        return binding.root
    }

    private fun highlightToday(binding: LayoutCalendarCellBinding, position: Int) {
        binding.llRoot.setBackgroundResource(
            if (dates[position].date == LocalDate.now())
                R.drawable.bg_selected_rectangle
            else
                R.drawable.bg_rounded_rectangle
        )
    }
}


interface SelectDateListener {
    fun onDateSelected(position: Int, date: String)
}
