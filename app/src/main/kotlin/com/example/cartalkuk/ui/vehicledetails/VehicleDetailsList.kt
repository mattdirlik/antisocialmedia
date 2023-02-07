package com.example.cartalkuk.ui.vehicledetails

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cartalkuk.ui.layout.DetailListDividerLayout

@Composable
fun VehicleDetailsList(
    colour: String,
    make: String,
    firstRegDate: String?,
    firstDvlaRegDate: String?,
    engineCapacity: Int?,
    co2Emissions: Int?
) {
    DetailListDividerLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        KeyValueText(key = "Make", value = make)
        firstRegDate?.let {
            KeyValueText(
                key = "Date of first registration",
                value = it
            )
        }
        firstDvlaRegDate?.let {
            KeyValueText(
                key = "Date of first DVLA registration",
                value = it
            ) }
        engineCapacity?.let {
            KeyValueText(
                key = "Engine capacity",
                value = it.toString() + "cc"
            )
        }
        co2Emissions?.let {
            KeyValueText(
                key = "CO2 Emissions",
                value = it.toString() + "kg/m"
            )
        }
        KeyValueText(key = "Colour", value = colour)
    }
}

@Composable
fun KeyValueText(
    modifier: Modifier = Modifier,
    key: String,
    value: String
) {
    Row(
        modifier = modifier
    ) {
        Text(text = key)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = value)
    }
}

@Preview
@Composable
fun VehicleDetailsListPreview() {
    VehicleDetailsList(
        colour = "purple",
        make = "lambo",
        firstRegDate = "yesterday",
        firstDvlaRegDate = "damn",
        engineCapacity = 23,
        co2Emissions = 59
    )
}