package com.notsatria.sepathu.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.notsatria.sepathu.ui.components.ShoeItem
import com.notsatria.sepathu.utils.DataDummy

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(DataDummy.generateDummyShoe()) { shoe ->
               ShoeItem(shoe = shoe)
            }
        },
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    )
}
