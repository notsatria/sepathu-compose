package com.notsatria.sepathu.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.notsatria.sepathu.ui.theme.DotIndicatorDefault
import com.notsatria.sepathu.ui.theme.Purple

@Composable
fun Indicator(
    dotCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier,
    dotSpacing: Dp = 8.dp,
    dotSize: Dp = 10.dp,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(dotSpacing),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        for (i in 0 until dotCount) {
            val isActive = currentPage == i
            val color by animateColorAsState(targetValue =  if (isActive) Purple else DotIndicatorDefault,
                label = ""
            )
            val width by animateDpAsState(targetValue = if (isActive) dotSize * 3 else dotSize,
                label = ""
            )
            Box(
                modifier = Modifier
                    .width(width)
                    .height(dotSize)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}