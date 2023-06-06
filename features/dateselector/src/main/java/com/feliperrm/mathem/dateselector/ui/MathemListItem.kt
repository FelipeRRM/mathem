package com.feliperrm.mathem.dateselector.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MathemListItem(modifier: Modifier = Modifier, block: @Composable () -> Unit) {
    ElevatedCard(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .padding(bottom = 8.dp)
    ) { block() }
}
