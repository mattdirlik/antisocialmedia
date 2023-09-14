package com.example.cartalkuk.ui.vehicledetails.statusvalidity

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.cartalkuk.ui.theme.InvalidColour
import com.example.cartalkuk.ui.theme.UnknownColour
import com.example.cartalkuk.ui.theme.ValidColour
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun StatusValidityCard(
    modifier: Modifier = Modifier,
    variant: StatusValidityCard.StatusValidityCardVariant,
    statusText: String,
    date: String?,
    type: String,
) {
    Card(
        modifier = modifier,
        border = BorderStroke(
            width = 2.dp,
            color = variant.colour
        )
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = statusText,
                style = MaterialTheme.typography.titleMedium,
                color = variant.colour,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Icon(
                modifier = Modifier.size(64.dp),
                imageVector = variant.icon,
                contentDescription = "",
                tint = variant.colour
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            colors = CardDefaults.cardColors(
                containerColor = variant.colour
            )
        ) {
            val formattedDate = date?.let {
                val parsedDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE)
                type + DateTimeFormatter.ofPattern("dd MMM, yyyy").format(parsedDate)
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = formattedDate ?: "No date details",
                    color = MaterialTheme.colorScheme.surface
                )
            }
        }
    }
}

object StatusValidityCard {
    sealed class StatusValidityCardVariant {
        abstract val colour: Color
        abstract val icon: ImageVector

        object ValidVariant : StatusValidityCardVariant() {
            override val colour = ValidColour
            override val icon = Icons.Default.Check
        }

        object InvalidVariant : StatusValidityCardVariant() {
            override val colour = InvalidColour
            override val icon = Icons.Default.Close
        }

        object UnknownVariant : StatusValidityCardVariant() {
            override val colour = UnknownColour
            override val icon = Icons.Default.Warning
        }
    }
}