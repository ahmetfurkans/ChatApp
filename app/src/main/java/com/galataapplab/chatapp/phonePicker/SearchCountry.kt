package com.galataapplab.chatapp.phonePicker

import androidx.compose.ui.text.toLowerCase

fun searchCountry(query: String): List<CountryData> {
    val result = mutableListOf<CountryData>()

    countryList.forEach {
        if (it.cNames.lowercase()
                .contains(query.lowercase()) || it.countryPhoneCode.contains(query.lowercase()) || it.cCodes.contains(
                query.lowercase()
            )
        ) {
            result.add(it)
        }
    }
    return result
}