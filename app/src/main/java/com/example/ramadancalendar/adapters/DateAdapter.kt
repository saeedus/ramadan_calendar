package com.example.ramadancalendar.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.ramadancalendar.R
import com.example.ramadancalendar.databinding.LayoutCalendarCellBinding
import com.example.ramadancalendar.model.DateModel

class DateAdapter(
    private val context: Context,
    private val dates: ArrayList<DateModel>,
    private val selectDateListener: SelectDateListener
) :
    BaseAdapter() {
    private var selectedPosition = -1
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

        binding.tvDate.text = dates[position].date
        binding.root.setOnClickListener {
            selectDateListener.onDateSelected(position, date = dates[position].date)

            val oldSelectedPosition = selectedPosition
            selectedPosition = position

            if (oldSelectedPosition != selectedPosition) {
                if (oldSelectedPosition >= 0) {
                    (parent.getChildAt(oldSelectedPosition).tag as ViewDataBinding).root
                        .setBackgroundColor(
                            context.resources.getColor(R.color.pink)
                        )
                }
                binding.root.setBackgroundColor(context.resources.getColor(R.color.white))
            }
        }
        binding.root.tag = binding
        return binding.root
    }


    interface SelectDateListener {
        fun onDateSelected(position: Int, date: String)
    }

}
