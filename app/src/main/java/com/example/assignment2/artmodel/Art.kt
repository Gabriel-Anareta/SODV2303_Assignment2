package com.example.assignment2.artmodel

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Art(
    @StringRes val titleID: Int,
    @StringRes val authorID: Int,
    @StringRes val yearID: Int,
    @DrawableRes val artId: Int
)
