package com.notsatria.sepathu.utils

import java.text.DecimalFormat

fun Double.convertToDollar(): String {
    val format = DecimalFormat("#,###.00")
    format.isDecimalSeparatorAlwaysShown = false
    return "$${format.format(this)}"
}