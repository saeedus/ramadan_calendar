package com.example.ramadancalendar.utility

class Utils {

    fun toBanglaDayOfWeek(englishText: String): String {
        val banglaMap = mapOf(
            "monday" to "সোমবার",
            "tuesday" to "মঙ্গলবার",
            "wednesday" to "বুধবার",
            "thursday" to "বৃহস্পতিবার",
            "friday" to "শুক্রবার",
            "saturday" to "শনিবার",
            "sunday" to "রবিবার",
        )
        return banglaMap[englishText.trim().lowercase()] ?: englishText
    }

    fun toBanglaDigit(englishDigit: Int): String {
        val banglaDigits = arrayOf(
            "১", "২", "৩", "৪", "৫", "৬", "৭", "৮", "৯", "১০",
            "১১", "১২", "১৩", "১৪", "১৫", "১৬", "১৭", "১৮", "১৯", "২০",
            "২১", "২২", "২৩", "২৪", "২৫", "২৬", "২৭", "২৮", "২৯", "৩০", "৩১"
        )
        return banglaDigits[englishDigit - 1]
    }

    fun toBanglaMonth(englishMonth: String): String {
        val banglaMonths = mapOf(
            "january" to "জানুয়ারি",
            "february" to "ফেব্রুয়ারি",
            "march" to "মার্চ",
            "april" to "এপ্রিল",
            "may" to "মে",
            "june" to "জুন",
            "july" to "জুলাই",
            "august" to "আগস্ট",
            "september" to "সেপ্টেম্বর",
            "october" to "অক্টোবর",
            "november" to "নভেম্বর",
            "december" to "ডিসেম্বর"
        )
        return banglaMonths[englishMonth.trim().lowercase()] ?: englishMonth
    }


    fun toBanglaTime(englishTime: String): String {
        val banglaDigits = mapOf(
            '0' to '০', '1' to '১', '2' to '২', '3' to '৩', '4' to '৪', '5' to '৫',
            '6' to '৬', '7' to '৭', '8' to '৮', '9' to '৯'
        )
        var banglaTime = ""
        for (char in englishTime) {
            banglaTime += banglaDigits[char] ?: char
        }
        return banglaTime
    }


}