package com.basalamah.muhammadsyarif.myfootballmatch

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class Utils {
    @SuppressLint("SimpleDateFormat")
    fun GMT(strDate: String, strTime: String): String {
        val formatter = SimpleDateFormat("dd/MM/yy HH:mm:ss")
        formatter.timeZone = TimeZone.getTimeZone("UTC")
        val dateTime = "$strDate $strTime"
        return formatter.parse(dateTime).toString()
    }
}