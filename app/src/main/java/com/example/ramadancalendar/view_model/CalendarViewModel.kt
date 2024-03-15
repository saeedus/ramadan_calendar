package com.example.ramadancalendar.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ramadancalendar.model.DateModel

class CalendarViewModel : ViewModel() {


    fun getRamadanDate(): LiveData<List<DateModel>> {
        val data = MutableLiveData<List<DateModel>>()

        val initialData = listOf(
            DateModel("১", "১২", "মঙ্গলবার", "মার্চ", "৬:১০", "৪:৫১"),
            DateModel("১", "১২", "মঙ্গলবার", "মার্চ", "৬:১০", "৪:৫১"),
            DateModel("২", "১৩", "বুধবার", "মার্চ", "৬:১০", "৪:৫০"),
            DateModel("৩", "১৪", "বৃহস্পতিবার", "মার্চ", "৬:১১", "৪:৪৯"),
            DateModel("৪", "১৫", "শুক্রবার", "মার্চ", "৬:১১", "৪:৪৮"),
            DateModel("৫", "১৬", "শনিবার", "মার্চ", "৬:১২", "৪:৪৭"),
            DateModel("৬", "১৭", "রবিবার", "মার্চ", "৬:১২", "৪:৪৬"),
            DateModel("৭", "১৮", "সোমবার", "মার্চ", "৬:১২", "৪:৪৫"),
            DateModel("৮", "১৯", "মঙ্গলবার", "মার্চ", "৬:১৩", "৪:৪৪"),
            DateModel("৯", "২০", "বুধবার", "মার্চ", "৬:১৩", "৪:৪৩"),
            DateModel("১০", "২১", "বৃহস্পতিবার", "মার্চ", "৬:১৩", "৪:৪২"),
            DateModel("১১", "২২", "শুক্রবার", "মার্চ", "৬:১৪", "৪:৪১"),
            DateModel("১২", "২৩", "শনিবার", "মার্চ", "৬:১৪", "৪:৪০"),
            DateModel("১৩", "২৪", "রবিবার", "মার্চ", "৬:১৪", "৪:৩৯"),
            DateModel("১৪", "২৫", "সোমবার", "মার্চ", "৬:১৫", "৪:৩৮"),
            DateModel("১৫", "২৬", "মঙ্গলবার", "মার্চ", "৬:১৫", "৪:৩৬"),
            DateModel("১৬", "২৭", "বুধবার", "মার্চ", "৬:১৬", "৪:৩৫"),
            DateModel("১৭", "২৮", "বৃহস্পতিবার", "মার্চ", "৬:১৬", "৪:৩৪"),
            DateModel("১৮", "২৯", "শুক্রবার", "মার্চ", "৬:১৭", "৪:৩৩"),
            DateModel("১৯", "৩০", "শনিবার", "মার্চ", "৬:১৭", "৪:৩১"),
            DateModel("২০", "৩১", "রবিবার", "মার্চ", "৬:১৮", "৪:৩০"),
            DateModel("২১", "১", "সোমবার", "এপ্রিল", "৬:১৮", "৪:২৯"),
            DateModel("২২", "২", "মঙ্গলবার", "এপ্রিল", "৬:১৯", "৪:২৮"),
            DateModel("২৩", "৩", "বুধবার", "এপ্রিল", "৬:১৯", "৪:২৭"),
            DateModel("২৪", "৪", "বৃহস্পতিবার", "এপ্রিল", "৬:১৯", "৪:২৬"),
            DateModel("২৫", "৫", "শুক্রবার", "এপ্রিল", "৬:২০", "৪:২৪"),
            DateModel("২৬", "৬", "শনিবার", "এপ্রিল", "৬:২০", "৪:২৪"),
            DateModel("২৭", "৭", "রবিবার", "এপ্রিল", "৬:২১", "৪:২৩"),
            DateModel("২৮", "৮", "সোমবার", "এপ্রিল", "৬:২১", "৪:২২"),
            DateModel("২৯", "৯", "মঙ্গলবার", "এপ্রিল", "৬:২১", "৪:২১"),
            DateModel("৩০", "১০", "বুধবার", "এপ্রিল", "৬:২২", "৪:২০")
        )

        data.value = initialData.toMutableList()

        return data
    }


}