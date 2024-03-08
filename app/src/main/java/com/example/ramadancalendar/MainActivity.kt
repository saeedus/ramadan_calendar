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
    private val data = ArrayList<DateModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        data.add(DateModel("১", "১২", "মঙ্গলবার", "মার্চ", "৬:১০", "৪:৫১"))
        data.add(DateModel("২", "১৩", "বুধবার", "মার্চ", "৬:১০", "৪:৫০"))
        data.add(DateModel("৩", "১৪", "বৃহস্পতিবার", "মার্চ", "৬:১১", "৪:৪৯"))
        data.add(DateModel("৪", "১৫", "শুক্রবার", "মার্চ", "৬:১১", "৪:৪৮"))
        data.add(DateModel("৫", "১৬", "শনিবার", "মার্চ", "৬:১২", "৪:৪৭"))
        data.add(DateModel("৬", "১৭", "রবিবার", "মার্চ", "৬:১২", "৪:৪৬"))
        data.add(DateModel("৭", "১৮", "সোমবার", "মার্চ", "৬:১২", "৪:৪৫"))
        data.add(DateModel("৮", "১৯", "মঙ্গলবার", "মার্চ", "৬:১৩", "৪:৪৪"))
        data.add(DateModel("৯", "২০", "বুধবার", "মার্চ", "৬:১৩", "৪:৪৩"))
        data.add(DateModel("১০", "২১", "বৃহস্পতিবার", "মার্চ", "৬:১৩", "৪:৪২"))
        data.add(DateModel("১১", "২২", "শুক্রবার", "মার্চ", "৬:১৪", "৪:৪১"))
        data.add(DateModel("১২", "২৩", "শনিবার", "মার্চ", "৬:১৪", "৪:৪০"))
        data.add(DateModel("১৩", "২৪", "রবিবার", "মার্চ", "৬:১৪", "৪:৩৯"))
        data.add(DateModel("১৪", "২৫", "সোমবার", "মার্চ", "৬:১৫", "৪:৩৮"))
        data.add(DateModel("১৫", "২৬", "মঙ্গলবার", "মার্চ", "৬:১৫", "৪:৩৬"))
        data.add(DateModel("১৬", "২৭", "বুধবার", "মার্চ", "৬:১৬", "৪:৩৫"))
        data.add(DateModel("১৭", "২৮", "বৃহস্পতিবার", "মার্চ", "৬:১৬", "৪:৩৪"))
        data.add(DateModel("১৮", "২৯", "শুক্রবার", "মার্চ", "৬:১৭", "৪:৩৩"))
        data.add(DateModel("১৯", "৩০", "শনিবার", "মার্চ", "৬:১৭", "৪:৩১"))
        data.add(DateModel("২০", "৩১", "রবিবার", "মার্চ", "৬:১৮", "৪:৩০"))
        data.add(DateModel("২১", "১", "সোমবার", "এপ্রিল", "৬:১৮", "৪:২৯"))
        data.add(DateModel("২২", "২", "মঙ্গলবার", "এপ্রিল", "৬:১৯", "৪:২৮"))
        data.add(DateModel("২৩", "৩", "বুধবার", "এপ্রিল", "৬:১৯", "৪:২৭"))
        data.add(DateModel("২৪", "৪", "বৃহস্পতিবার", "এপ্রিল", "৬:১৯", "৪:২৬"))
        data.add(DateModel("২৫", "৫", "শুক্রবার", "এপ্রিল", "৬:২০", "৪:২৪"))
        data.add(DateModel("২৬", "৬", "শনিবার", "এপ্রিল", "৬:২০", "৪:২৪"))
        data.add(DateModel("২৭", "৭", "রবিবার", "এপ্রিল", "৬:২১", "৪:২৩"))
        data.add(DateModel("২৮", "৮", "সোমবার", "এপ্রিল", "৬:২১", "৪:২২"))
        data.add(DateModel("২৯", "৯", "মঙ্গলবার", "এপ্রিল", "৬:২১", "৪:২১"))
        data.add(DateModel("৩০", "১০", "বুধবার", "এপ্রিল", "৬:২২", "৪:২০"))


        val gridView = binding.gvCalendar
        val adapter = DateAdapter(this, data, object : DateAdapter.SelectDateListener {
            override fun onDateSelected(position: Int, date: String) {
                binding.tvEngDate.text =
                    "${data[position].englishDate} ${data[position].month}, ${data[position].day}"
                binding.tvSehriTime.text = data[position].sehriTime
                binding.tvIftarTime.text = data[position].iftarTime
            }


        })
        gridView.adapter = adapter
    }


}

