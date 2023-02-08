package com.example.cartalkuk.ui.queryconfirmation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cartalkuk.ui.queryconfirmation.QueryConfirmationCard.ButtonSpacerWidth
import com.example.cartalkuk.ui.queryconfirmation.QueryConfirmationCard.ConfirmationCardContentPadding
import com.example.cartalkuk.ui.queryconfirmation.QueryConfirmationCard.ConfirmationCardPadding
import com.example.cartalkuk.ui.queryconfirmation.QueryConfirmationCard.ConfirmationPromptText
import com.example.cartalkuk.ui.queryconfirmation.QueryConfirmationCard.NoButtonText
import com.example.cartalkuk.ui.queryconfirmation.QueryConfirmationCard.PreviewColour
import com.example.cartalkuk.ui.queryconfirmation.QueryConfirmationCard.PreviewMake
import com.example.cartalkuk.ui.queryconfirmation.QueryConfirmationCard.WordSpacerWidth
import com.example.cartalkuk.ui.queryconfirmation.QueryConfirmationCard.YesButtonText

@Composable
fun QueryConfirmationCard(
    onConfirmationButtonClick: (isConfirmed: Boolean) -> Unit,
    colour: String?,
    make: String?
) {
    Card(
        modifier = Modifier.padding(ConfirmationCardPadding)
    ) {
        Text(
            modifier = Modifier.padding(ConfirmationCardContentPadding),
            text = ConfirmationPromptText
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(ConfirmationCardContentPadding),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = colour ?: "")
            Spacer(modifier = Modifier.width(WordSpacerWidth))
            Text(text = make ?: "")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(ConfirmationCardContentPadding),
            horizontalArrangement = Arrangement.spacedBy(ButtonSpacerWidth)
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = { onConfirmationButtonClick(true) }
            ) {
                Text(text = YesButtonText)
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = { onConfirmationButtonClick(false) }
            ) {
                Text(text = NoButtonText)
            }
        }
    }
}

@Preview
@Composable
fun QueryConfirmationCardPreview() {
    QueryConfirmationCard(
        onConfirmationButtonClick = {},
        colour = PreviewColour,
        make = PreviewMake
    )
}

private object QueryConfirmationCard {
    const val ConfirmationPromptText = "Does this sound like the car you're looking for?"
    const val YesButtonText = "Yes"
    const val NoButtonText = "No"
    const val PreviewColour = "Purple"
    const val PreviewMake = "Lamborghini"

    val ConfirmationCardPadding = 24.dp
    val ConfirmationCardContentPadding = 16.dp
    val ButtonSpacerWidth = 16.dp
    val WordSpacerWidth = 4.dp
}