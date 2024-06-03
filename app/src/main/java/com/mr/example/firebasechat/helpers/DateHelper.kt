package com.mr.example.firebasechat.helpers

import android.icu.text.DateFormat
import java.util.*


/** Extension function to convert a Long timestamp to a formatted date time string
 * @return Formatted date time string
 */
fun Long.toDateTimeString():String{
    // Create a DateFormat object with the desired date format
    val df = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT, Locale.getDefault())
    // Create a Date object from the Long timestamp and format it with the SimpleDateFormat
    return df.format(this)
}