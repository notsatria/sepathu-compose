package com.notsatria.sepathu.utils

fun getCategoryName(id: Int): String {
    return when(id) {
        0 -> "Running"
        1 -> "Walking"
        2 -> "Hiking"
        3 -> "Basketball"
        else -> "Unknown"
    }
}