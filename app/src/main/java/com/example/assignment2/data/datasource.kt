package com.example.assignment2.data

import com.example.assignment2.R
import com.example.assignment2.artmodel.Art

class datasource() {
    fun loadArtSources(): List<Art> {
        return listOf<Art>(
            Art(R.string.title1, R.string.author1, R.string.date1, R.drawable.autumnleaf),
            Art(R.string.title2, R.string.author2, R.string.date2, R.drawable.city),
            Art(R.string.title3, R.string.author3, R.string.date3, R.drawable.sky)
        )
    }
}
