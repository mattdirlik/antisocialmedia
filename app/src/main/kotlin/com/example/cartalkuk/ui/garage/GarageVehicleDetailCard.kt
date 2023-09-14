package com.example.cartalkuk.ui.garage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cartalkuk.R
import com.example.cartalkuk.database.entity.VehicleEntity
import com.example.cartalkuk.ui.vehicledetails.MotStatus.NoDetailsHeld
import com.example.cartalkuk.ui.vehicledetails.MotStatus.NoResults
import com.example.cartalkuk.ui.vehicledetails.MotStatus.NotValid
import com.example.cartalkuk.ui.vehicledetails.MotStatus.Valid
import com.example.cartalkuk.ui.vehicledetails.RegistrationPlate
import com.example.cartalkuk.ui.vehicledetails.TaxStatus.NotRoadTaxed
import com.example.cartalkuk.ui.vehicledetails.TaxStatus.Sorn
import com.example.cartalkuk.ui.vehicledetails.TaxStatus.Taxed
import com.example.cartalkuk.ui.vehicledetails.TaxStatus.Untaxed
import com.example.cartalkuk.ui.vehicledetails.statusvalidity.StatusValidityCard.StatusValidityCardVariant.InvalidVariant
import com.example.cartalkuk.ui.vehicledetails.statusvalidity.StatusValidityCard.StatusValidityCardVariant.UnknownVariant
import com.example.cartalkuk.ui.vehicledetails.statusvalidity.StatusValidityCard.StatusValidityCardVariant.ValidVariant

@Composable
fun GarageVehicleDetailCard(
    modifier: Modifier = Modifier,
    vehicle: VehicleEntity,
    onClick: () -> Unit = {}
) {
    with(vehicle) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(
                    color = MaterialTheme.colorScheme.secondaryContainer
                )
                .clickable {
                    onClick()
                }
                .padding(8.dp)
        ) {
            Row(
                horizontalArrangement = spacedBy(8.dp)
            ) {
                Icons.Default.AddCircle
                Image(
                    modifier = Modifier.size(128.dp),
                    painter = painterResource(id = R.drawable.ic_garage),
                    contentDescription = "placeholder icon"
                )

                Column(
                    verticalArrangement = spacedBy(8.dp)
                ) {
                    RegistrationPlate(registration = registrationNumber)

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        taxStatus?.let {
                            GarageTaxStatusMarker(taxStatus = it)
                        }

                        motStatus?.let {
                            GarageMotStatusMarker(motStatus = it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GarageTaxStatusMarker(
    modifier: Modifier = Modifier,
    taxStatus: String
) {
    val taxVariant = when (taxStatus) {
        Taxed.validity -> ValidVariant
        Untaxed.validity -> InvalidVariant
        NotRoadTaxed.validity,
        Sorn.validity -> UnknownVariant

        else -> UnknownVariant
    }

    Box(
        modifier = modifier
            .size(64.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = taxVariant.colour)
    ) {
        Column(
            horizontalAlignment = CenterHorizontally
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Tax",
                color = MaterialTheme.colorScheme.background,
                textAlign = Center
            )

            Icon(
                modifier = Modifier.size(64.dp),
                imageVector = taxVariant.icon,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.background
            )
        }
    }
}

@Composable
fun GarageMotStatusMarker(
    modifier: Modifier = Modifier,
    motStatus: String
) {
    val motVariant = when (motStatus) {
        Valid.validity -> ValidVariant
        NotValid.validity -> InvalidVariant
        NoResults.validity,
        NoDetailsHeld.validity -> UnknownVariant

        else -> UnknownVariant
    }

    Box(
        modifier = modifier
            .size(64.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = motVariant.colour)
    ) {
        Column(
            horizontalAlignment = CenterHorizontally
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "MOT",
                color = MaterialTheme.colorScheme.background,
                textAlign = Center
            )

            Icon(
                modifier = Modifier.size(64.dp),
                imageVector = motVariant.icon,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.background
            )
        }
    }
}

@Preview
@Composable
fun GarageVehicleDetailCardPreview() {
    GarageVehicleDetailCard(
        vehicle = VehicleEntity(
            make = "Suzuki",
            registrationNumber = "YY03 TKT",
            taxStatus = "",
            motStatus = Valid.validity
        )
    )
}