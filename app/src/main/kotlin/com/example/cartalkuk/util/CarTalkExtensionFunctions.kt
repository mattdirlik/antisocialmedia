package com.example.cartalkuk.util

fun String.toLicensePlateFormat() = this
    .replace(
        regex = Regex("[^A-Za-z0-9 ]"),
        replacement = ""
    ).uppercase()