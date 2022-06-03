package com.ands.newstestapp.common

import android.content.Context
import com.ands.newstestapp.R
import java.text.SimpleDateFormat
import java.util.*
import java.util.Locale.US
import java.util.concurrent.TimeUnit

/**
 * Created by Dad52(Sobolev) on 6/3/2022.
 */
class DateTimeMapper(
    inputPattern: String = "yyyy-MM-dd'T'HH:mm:ss'Z'",
    outputPattern: String = "dd MMM",
    private val context: Context
) : Mapper<String, String> {

    private val dateInput = SimpleDateFormat(inputPattern, US)
    private val dateOutput = SimpleDateFormat(outputPattern, US)

    override fun map(source: String): String {

        val past = dateInput.parse(source) ?: return ""

        val now = Date()

        val seconds: Long = TimeUnit.MILLISECONDS.toSeconds(now.time - past.time)
        val minutes: Long = TimeUnit.MILLISECONDS.toMinutes(now.time - past.time)
        val hours: Long = TimeUnit.MILLISECONDS.toHours(now.time - past.time)
        val days: Long = TimeUnit.MILLISECONDS.toDays(now.time - past.time)

        return when {
            seconds < 60 -> context.getString(R.string.placeholder_seconds_ago, seconds)
            minutes < 60 -> context.getString(R.string.placeholder_minutes_ago, minutes)
            hours < 24 -> context.getString(R.string.placeholder_hours_ago, hours)
            days < 7 -> context.getString(R.string.placeholder_days_ago, days)
            else -> return dateOutput.format(past)
        }
    }
}

interface Mapper<S, R> {
    fun map(source: S): R
}

