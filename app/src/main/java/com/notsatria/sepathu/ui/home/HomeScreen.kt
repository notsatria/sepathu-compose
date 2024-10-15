package com.notsatria.sepathu.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults.filterChipColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.notsatria.sepathu.R
import com.notsatria.sepathu.data.entities.getCategoryName
import com.notsatria.sepathu.ui.components.ShoeItem
import com.notsatria.sepathu.ui.theme.Purple
import com.notsatria.sepathu.ui.theme.TextDisabled
import com.notsatria.sepathu.ui.theme.TextGrey
import com.notsatria.sepathu.ui.theme.White
import com.notsatria.sepathu.utils.DataDummy
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val viewModel: HomeViewModel = koinViewModel()

    val categories = mapOf(
        4 to "All",
        0 to getCategoryName(0),
        1 to getCategoryName(1),
        2 to getCategoryName(2),
        3 to getCategoryName(3),
    )
    Column(modifier) {
        Text(
            stringResource(id = R.string.app_name),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = White,
            modifier = Modifier.padding(start = 16.dp, top = 20.dp)
        )
        Text(
            stringResource(R.string.happy_shopping, "Satria"),
            fontSize = 16.sp,
            color = TextGrey,
            modifier = Modifier.padding(start = 16.dp, top = 2.dp)
        )
        LazyRow {
            items(categories.values.toList()) { category ->
                ShoeCategoryChip(
                    onClick = {},
                    categoryName = category,
                    modifier = Modifier.padding(start = 16.dp, top = 20.dp)
                )
            }
        }
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(viewModel.shoes) { shoe ->
                    ShoeItem(shoe = shoe)
                }
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(top = 20.dp)
        )
    }
}

@Composable
fun ShoeCategoryChip(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    categoryName: String,
    selected: Boolean = true
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

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFF1E213A)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Preview
@Composable
fun ShoeCategoryChipPreview() {
    ShoeCategoryChip(onClick = {}, categoryName = "Running")
}