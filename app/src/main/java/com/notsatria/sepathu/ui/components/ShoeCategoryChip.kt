package com.notsatria.sepathu.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults.filterChipColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.notsatria.sepathu.ui.theme.Purple
import com.notsatria.sepathu.ui.theme.TextDisabled
import com.notsatria.sepathu.ui.theme.White

@Composable
fun ShoeCategoryChip(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    categoryName: String,
    selected: Boolean
) {
    FilterChip(
        modifier = modifier,
        selected = selected,
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        colors = filterChipColors(
            selectedContainerColor = if (selected) Purple else White,
            selectedLabelColor = if (selected) White else TextDisabled
        ),
        label = {
            Text(
                text = categoryName,
                fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp)
            )
        }
    )
}