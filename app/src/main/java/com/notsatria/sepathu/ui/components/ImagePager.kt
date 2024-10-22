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
import com.notsatria.sepathu.utils.DataDummy

@Composable
fun ImagePager(
    modifier: Modifier = Modifier,
    shoeId: Int,
    pagerState: PagerState,
    navigateBack: () -> Unit = {},
) {

    val images = DataDummy.getImagesById(shoeId)

    Column(modifier) {
        Box(modifier = Modifier) {
            HorizontalPager(state = pagerState) { page ->
                Image(
                    painter = painterResource(id = images[page]),
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