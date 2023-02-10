package com.example.cartalkuk.ui.layout

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DefaultDivider() {
    Divider(
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    )
}
@Composable
fun DetailListDividerLayout(
    modifier: Modifier = Modifier,
    divider: @Composable () -> Unit = { DefaultDivider() },
    content: @Composable () -> Unit
) {
    SubcomposeLayout(
        modifier = modifier
    ) {constraints ->
        val contentPlaceables = subcompose(
            slotId = "contentSlot",
            content = content
        ).map {
            it.measure(constraints)
        }
        val dividerPlaceables = subcompose(
            slotId = "dividerSlot",
            content = { repeat(contentPlaceables.size - 1) { divider() } }
        ).map {
            it.measure(constraints)
        }

        val contentHeight = contentPlaceables.sumOf { it.height }
        val dividersHeight = dividerPlaceables.sumOf { it.height }

        layout(
            width = contentPlaceables.maxOf { it.width },
            height = contentHeight + dividersHeight
        ) {
            var yOffset = 0
            contentPlaceables.forEachIndexed { index, placeable ->
                placeable.placeRelative(0, yOffset)
                yOffset += placeable.height

                if (index != contentPlaceables.lastIndex) {
                    dividerPlaceables[index].placeRelative(0, yOffset)
                    yOffset += dividerPlaceables[index].height
                }
            }
        }
    }
}

@Preview
@Composable
fun DetailListSeparatorLayoutPreview() {
    DetailListDividerLayout {
        Text("Tax Status: Taxed")
        Text("MOT Status: Valid")
    }
}