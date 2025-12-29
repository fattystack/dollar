package com.fatchoy.dollar.core.util

import java.text.NumberFormat
import java.util.Locale
import kotlin.math.abs

fun formatCurrency(
    value: Double,
    locale: Locale = Locale.getDefault()
): String {
    val nf = NumberFormat.getCurrencyInstance(locale)
    return nf.format(value) // $15,250.80
}

fun formatDelta(
    delta: Double,
    locale: Locale = Locale.getDefault(),
    showPlus: Boolean = true
): String {
    val nf = NumberFormat.getCurrencyInstance(locale)
    val absStr = nf.format(abs(delta))
    return when {
        delta > 0.0 && showPlus -> "+$absStr"
        delta > 0.0 -> absStr
        delta < 0.0 -> "-$absStr"
        else -> "+$absStr"
    }
}
