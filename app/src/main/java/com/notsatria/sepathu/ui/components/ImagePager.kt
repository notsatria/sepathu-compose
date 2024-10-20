package com.notsatria.sepathu.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.notsatria.sepathu.R
import com.notsatria.sepathu.ui.theme.DarkNavy

@Composable
fun ImagePager(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    navigateBack: () -> Unit = {},
) {
    Column(modifier) {
        Box(modifier = Modifier) {
            HorizontalPager(state = pagerState) { page ->
                val image = when (page) {
                    0 -> R.drawable.il_hiking_terrex_ax_1
                    1 -> R.drawable.il_hiking_terrex_ax_2
                    2 -> R.drawable.il_hiking_terrex_ax_3
                    else -> R.drawable.ic_launcher_background
                }
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Image"
                )
            }
            Indicator(
                dotCount = pagerState.pageCount,
                currentPage = pagerState.currentPage,
                dotSpacing = 4.dp,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 8.dp)
                    .height(12.dp)
            )
            IconButton(
                onClick = navigateBack, modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(
                        id = R.string.back
                    ),
                    tint = DarkNavy
                )
            }
        }

    }
}