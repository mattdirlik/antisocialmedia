package com.example.cartalkuk.ui.vehicledetails

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cartalkuk.ui.layout.DetailListDividerLayout
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsList.Co2EmissionsKey
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsList.Co2EmissionsSuffix
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsList.ColourKey
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsList.CylinderCapacitySuffix
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsList.EngineCapacityKey
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsList.EuroStatusKey
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsList.ExportMarkerKey
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsList.FirstDvlaRegDateKey
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsList.FirstRegDateKey
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsList.FuelTypeKey
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsList.MakeKey
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsList.RealDrivingEmissionsKey
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsList.RevenueWeightKey
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsList.RevenueWeightSuffix
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsList.V5CKey
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsList.VehicleDetailsListPadding
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsList.VehicleTypeApprovalKey
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsList.WheelplanKey
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsList.YearOfManufactureKey

@Composable
fun VehicleDetailsList(
    colour: String,
    make: String,
    firstRegDate: String?,
    firstDvlaRegDate: String?,
    yearOfManufacture: Int?,
    engineCapacity: Int?,
    co2Emissions: Int?,
    fuelType: String?,
    euroStatus: String?,
    realDrivingEmissions: String?,
    exportMarker: Boolean?,
    vehicleTypeApproval: String?,
    wheelplan: String?,
    revenueWeight: Int?,
    v5cDate: String?
) {
    DetailListDividerLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(VehicleDetailsListPadding)
    ) {
        KeyValueText(key = MakeKey, value = make)
        KeyValueText(key = ColourKey, value = colour)
        firstRegDate?.let {
            KeyValueText(
                key = FirstRegDateKey,
                value = it
            )
        }
        firstDvlaRegDate?.let {
            KeyValueText(
                key = FirstDvlaRegDateKey,
                value = it
            )
        }
        yearOfManufacture?.let {
            KeyValueText(
                key = YearOfManufactureKey,
                value = it.toString()
            )
        }
        engineCapacity?.let {
            KeyValueText(
                key = EngineCapacityKey,
                value = it.toString() + CylinderCapacitySuffix
            )
        }
        co2Emissions?.let {
            KeyValueText(
                key = Co2EmissionsKey,
                value = it.toString() + Co2EmissionsSuffix
            )
        }
        fuelType?.let {
            KeyValueText(
                key = FuelTypeKey,
                value = it
            )
        }
        euroStatus?.let {
            KeyValueText(
                key = EuroStatusKey,
                value = it
            )
        }
        realDrivingEmissions?.let {
            KeyValueText(
                key = RealDrivingEmissionsKey,
                value = it
            )
        }
        exportMarker?.let { isMarked ->
            KeyValueText(
                key = ExportMarkerKey,
                value = "Yes".takeIf { isMarked } ?: "No"
            )
        }
        vehicleTypeApproval?.let {
            KeyValueText(
                key = VehicleTypeApprovalKey,
                value = it
            )
        }
        wheelplan?.let {
            KeyValueText(
                key = WheelplanKey,
                value = it
            )
        }
        revenueWeight?.let {
            KeyValueText(
                key = RevenueWeightKey,
                value = it.toString() + RevenueWeightSuffix
            )
        }
        v5cDate?.let {
            KeyValueText(
                key = V5CKey,
                value = it
            )
        }
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
        Text(
            text = key,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Preview
@Composable
fun VehicleDetailsListPreview() {
    Surface {
        VehicleDetailsList(
            colour = "purple",
            make = "lambo",
            firstRegDate = "yesterday",
            firstDvlaRegDate = "damn",
            yearOfManufacture = 2003,
            engineCapacity = 23,
            co2Emissions = 59,
            euroStatus = "Not available",
            realDrivingEmissions = "2",
            exportMarker = true,
            fuelType = "Petrol",
            vehicleTypeApproval = "N1",
            wheelplan = "2 AXLE RIGID BODY",
            revenueWeight = 1640,
            v5cDate = "2021-07-08"
        )
    }
}

private object VehicleDetailsList {
    const val MakeKey = "Make"
    const val ColourKey = "Colour"
    const val FirstRegDateKey = "Date of first registration"
    const val FirstDvlaRegDateKey = "Date of first DVLA registration"
    const val YearOfManufactureKey = "Year of manufacture"
    const val EngineCapacityKey = "Engine capacity"
    const val CylinderCapacitySuffix = " cc"
    const val Co2EmissionsSuffix = " ᵍ⁄ₖₘ"
    const val Co2EmissionsKey = "CO₂ emissions"
    const val FuelTypeKey = "Fuel type"
    const val EuroStatusKey = "Euro status"
    const val RealDrivingEmissionsKey = "Real driving emissions"
    const val ExportMarkerKey = "Export marker"
    const val VehicleTypeApprovalKey = "Vehicle type approval"
    const val WheelplanKey = "Wheelplan"
    const val RevenueWeightKey = "Revenue Date"
    const val RevenueWeightSuffix = " kg"
    const val V5CKey = "Last V5C (logbook) issued"

    val VehicleDetailsListPadding = 24.dp
}