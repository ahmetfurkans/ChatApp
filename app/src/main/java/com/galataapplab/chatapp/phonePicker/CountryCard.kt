package com.galataapplab.chatapp.phonePicker

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.galataapplab.chatapp.core.presentation.theme.countryPrimary
import com.galataapplab.chatapp.core.presentation.theme.inactivePrimaryButton
import com.galataapplab.chatapp.core.presentation.theme.primaryButton

@Composable
fun CountryCard(
    modifier: Modifier = Modifier, country: CountryData, onItemSelected: (CountryData) -> Unit
) {

    Row(modifier = modifier
        .background(MaterialTheme.colors.countryPrimary, shape = RoundedCornerShape(4.dp))
        .clickable {
            onItemSelected(country)
        }
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Image(
            painterResource(getFlags(country.cCodes)),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
                .clip(RoundedCornerShape(6.dp))
        )
        Text(
            text = "${country.cNames}",
            style = MaterialTheme.typography.body1.copy(color = Color(0xFFADB5BD)),
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(2f),
            textAlign = TextAlign.Left
        )
        Text(
            text = "${country.countryPhoneCode}",
            modifier = Modifier.padding(start = 8.dp),
            style = MaterialTheme.typography.body1.copy(color = Color(0xFFADB5BD)),
        )
    }
}

@Composable
@Preview(showBackground = true)
fun CountryCardPreview() {
    CountryCard(country = countryList[1], onItemSelected = {})
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun CountryCardDarkPreview() {
    CountryCard(country = countryList[1], onItemSelected = {})
}
