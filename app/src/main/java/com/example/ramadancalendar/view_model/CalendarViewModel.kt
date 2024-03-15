package com.example.ramadancalendar.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ramadancalendar.model.DateModel
import java.time.LocalDate
import java.time.LocalTime
import java.time.Month

class CalendarViewModel : ViewModel() {


    fun getRamadanDate(): LiveData<List<DateModel>> {
        val data = MutableLiveData<List<DateModel>>()

        val initialData = listOf(

            DateModel(
                "১",
                LocalDate.of(2024, Month.MARCH, 12),
                LocalTime.of(18, 10),
                LocalTime.of(4, 51)
            ),
            DateModel(
                "২",
                LocalDate.of(2024, Month.MARCH, 13),
                LocalTime.of(18, 10),
                LocalTime.of(4, 50)
            ),
            DateModel(
                "৩",
                LocalDate.of(2024, Month.MARCH, 14),
                LocalTime.of(18, 11),
                LocalTime.of(4, 49)
            ),
            DateModel(
                "৪",
                LocalDate.of(2024, Month.MARCH, 15),
                LocalTime.of(18, 11),
                LocalTime.of(4, 48)
            ),
            DateModel(
                "৫",
                LocalDate.of(2024, Month.MARCH, 16),
                LocalTime.of(18, 12),
                LocalTime.of(4, 47)
            ),
            DateModel(
                "৬",
                LocalDate.of(2024, Month.MARCH, 17),
                LocalTime.of(18, 12),
                LocalTime.of(4, 46)
            ),
            DateModel(
                "৭",
                LocalDate.of(2024, Month.MARCH, 18),
                LocalTime.of(18, 12),
                LocalTime.of(4, 45)
            ),
            DateModel(
                "৮",
                LocalDate.of(2024, Month.MARCH, 19),
                LocalTime.of(18, 13),
                LocalTime.of(4, 44)
            ),
            DateModel(
                "৯",
                LocalDate.of(2024, Month.MARCH, 20),
                LocalTime.of(18, 13),
                LocalTime.of(4, 43)
            ),
            DateModel(
                "১০",
                LocalDate.of(2024, Month.MARCH, 21),
                LocalTime.of(18, 13),
                LocalTime.of(4, 42)
            ),
            DateModel(
                "১১",
                LocalDate.of(2024, Month.MARCH, 22),
                LocalTime.of(18, 14),
                LocalTime.of(4, 41)
            ),
            DateModel(
                "১২",
                LocalDate.of(2024, Month.MARCH, 23),
                LocalTime.of(18, 14),
                LocalTime.of(4, 40)
            ),
            DateModel(
                "১৩",
                LocalDate.of(2024, Month.MARCH, 24),
                LocalTime.of(18, 14),
                LocalTime.of(4, 39)
            ),
            DateModel(
                "১৪",
                LocalDate.of(2024, Month.MARCH, 25),
                LocalTime.of(18, 15),
                LocalTime.of(4, 38)
            ),
            DateModel(
                "১৫",
                LocalDate.of(2024, Month.MARCH, 26),
                LocalTime.of(18, 15),
                LocalTime.of(4, 36)
            ),
            DateModel(
                "১৬",
                LocalDate.of(2024, Month.MARCH, 27),
                LocalTime.of(18, 15),
                LocalTime.of(4, 35)
            ),
            DateModel(
                "১৭",
                LocalDate.of(2024, Month.MARCH, 28),
                LocalTime.of(18, 16),
                LocalTime.of(4, 34)
            ),
            DateModel(
                "১৮",
                LocalDate.of(2024, Month.MARCH, 29),
                LocalTime.of(18, 17),
                LocalTime.of(4, 33)
            ),
            DateModel(
                "১৯",
                LocalDate.of(2024, Month.MARCH, 30),
                LocalTime.of(18, 17),
                LocalTime.of(4, 31)
            ),
            DateModel(
                "২০",
                LocalDate.of(2024, Month.MARCH, 31),
                LocalTime.of(18, 18),
                LocalTime.of(4, 30)
            ),
            DateModel(
                "২১",
                LocalDate.of(2024, Month.APRIL, 1),
                LocalTime.of(18, 18),
                LocalTime.of(4, 29)
            ),
            DateModel(
                "২২",
                LocalDate.of(2024, Month.APRIL, 2),
                LocalTime.of(18, 19),
                LocalTime.of(4, 28)
            ),
            DateModel(
                "২৩",
                LocalDate.of(2024, Month.APRIL, 3),
                LocalTime.of(18, 19),
                LocalTime.of(4, 27)
            ),
            DateModel(
                "২৪",
                LocalDate.of(2024, Month.APRIL, 4),
                LocalTime.of(18, 19),
                LocalTime.of(4, 26)
            ),
            DateModel(
                "২৫",
                LocalDate.of(2024, Month.APRIL, 5),
                LocalTime.of(18, 20),
                LocalTime.of(4, 24)
            ),
            DateModel(
                "২৬",
                LocalDate.of(2024, Month.APRIL, 6),
                LocalTime.of(18, 20),
                LocalTime.of(4, 24)
            ),
            DateModel(
                "২৭",
                LocalDate.of(2024, Month.APRIL, 7),
                LocalTime.of(18, 21),
                LocalTime.of(4, 23)
            ),
            DateModel(
                "২৮",
                LocalDate.of(2024, Month.APRIL, 8),
                LocalTime.of(18, 21),
                LocalTime.of(4, 22)
            ),
            DateModel(
                "২৯",
                LocalDate.of(2024, Month.APRIL, 9),
                LocalTime.of(18, 21),
                LocalTime.of(4, 21)
            ),
            DateModel(
                "৩০",
                LocalDate.of(2024, Month.APRIL, 10),
                LocalTime.of(18, 22),
                LocalTime.of(4, 20)
            ),
        )

        data.value = initialData.toMutableList()

        return data
    }


}