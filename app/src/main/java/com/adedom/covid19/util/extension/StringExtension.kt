package com.adedom.covid19.util.extension

fun Int.format() = String.format("%,.0f", this.toDouble())
