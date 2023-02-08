package com.example.cartalkuk.ui.vehicledetails

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cartalkuk.data.model.VehicleEnquiryResponseModel
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsScreen.StatusValidityCardPadding
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun VehicleDetailsScreen(
    vehicle: VehicleEnquiryResponseModel
) {
    with(vehicle) {
        Row {
            StatusValidityCard(
                modifier = Modifier.weight(1f),
                title = taxStatus ?: "",
                date = taxDueDate ?: "",
                type = "Tax due: "
            )
            StatusValidityCard(
                modifier = Modifier.weight(1f),
                title = motStatus ?: "",
                date = motExpiryDate,
                type = "MOT expires: "
            )
        }

        VehicleDetailsList(
            colour = colour ?: "",
            make = make ?: "",
            firstRegDate = monthOfFirstRegistration,
            firstDvlaRegDate = monthOfFirstDvlaRegistration,
            engineCapacity = engineCapacity,
            co2Emissions = co2Emissions,
            euroStatus = euroStatus,
            yearOfManufacture = yearOfManufacture,
            realDrivingEmissions = realDrivingEmissions,
            exportMarker = markedForExport,
            fuelType = fuelType,
            vehicleTypeApproval = typeApproval,
            wheelplan = wheelplan,
            v5cDate = dateOfLastV5CIssued
        )
    }
}

@Composable
fun StatusValidityCard(
    modifier: Modifier = Modifier,
    title: String,
    date: String?,
    type: String
) {
    Card(
        modifier = Modifier
            .padding(StatusValidityCardPadding)
            .then(modifier),
        border = BorderStroke(
            width = 2.dp,
            color = Color(0xFF00703C)
        )
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                modifier = Modifier.size(48.dp),
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "",
                tint = Color(0xFF00703C)
            )
        }

        Card(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF00703C)
            )
        ) {
            val formattedDate = date?.let {
                val parsedDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE)
                type + DateTimeFormatter.ofPattern("dd MMM, yyyy").format(parsedDate)
            }
            Text(
                modifier = Modifier.padding(8.dp),
                text = formattedDate ?: "No date details",
                color = MaterialTheme.colorScheme.surface
            )
        }
    }
}

@Preview
@Composable
fun StatusValidityCardPreview() {
    StatusValidityCard(title = "Taxed", date = "2023-05-01", type = "Tax due: ")
}

@Preview
@Composable
fun VehicleDetailsScreenPreview() {
    Column {
        VehicleDetailsScreen(
            vehicle = VehicleEnquiryResponseModel(
                colour = "silver",
                make = "suzuki",
                taxStatus = "Taxed",
                taxDueDate = "1998-05-09",
                motStatus = "MOT Valid",
                motExpiryDate = "2021-12-30"
            )
        )
    }
}

object VehicleDetailsScreen {
    val StatusValidityCardPadding = 8.dp
}