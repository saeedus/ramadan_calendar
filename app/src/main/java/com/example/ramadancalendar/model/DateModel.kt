package com.example.ramadancalendar.model

data class DateModel(
    val date: String,
    val englishDate: String,
    val day: String,
    val month: String,
    val iftarTime: String,
    val sehriTime: String
)


data class PrayerTime(
    val fajr: String,
    val dhuhr: String,
    val asr: String,
    val maghrib: String,
    val isha: String
)