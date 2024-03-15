package com.example.ramadancalendar.model

import java.time.LocalDate
import java.time.LocalTime

data class DateModel(
    val date: LocalDate,
    val iftarTime: LocalTime,
    val sehriTime: LocalTime
)


data class PrayerTime(
    val fajr: String,
    val dhuhr: String,
    val asr: String,
    val maghrib: String,
    val isha: String
)