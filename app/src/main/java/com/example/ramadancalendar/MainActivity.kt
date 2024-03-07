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
        data.add(DateModel("১", "১২", "মঙ্গলবার", "৬:১০", "৪:৫১"))
        data.add(DateModel("২", "১৩", "বুধবার", "৬:১০", "৪:৫০"))
        data.add(DateModel("৩", "১৪", "বৃহস্পতিবার", "৬:১১", "৪:৪৯"))
        data.add(DateModel("৪", "১৫", "শুক্রবার", "৬:১১", "৪:৪৮"))
        data.add(DateModel("৫", "১৬", "শনিবার", "৬:১২", "৪:৪৭"))
        data.add(DateModel("৬", "১৭", "রবিবার", "৬:১২", "৪:৪৬"))
        data.add(DateModel("৭", "১৮", "সোমবার", "৬:১২", "৪:৪৫"))
        data.add(DateModel("৮", "১৯", "মঙ্গলবার", "৬:১৩", "৪:৪৪"))
        data.add(DateModel("৯", "২০", "বুধবার", "৬:১৩", "৪:৪৩"))
        data.add(DateModel("১০", "২১", "বৃহস্পতিবার", "৬:১৩", "৪:৪২"))
        data.add(DateModel("১১", "২২", "শুক্রবার", "৬:১৪", "৪:৪১"))


        val gridView = binding.gvCalendar
        val adapter = DateAdapter(this, data)
        gridView.adapter = adapter
    }
}

