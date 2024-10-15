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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.notsatria.sepathu.R
import com.notsatria.sepathu.ui.components.ShoeCategoryChip
import com.notsatria.sepathu.ui.components.ShoeItem
import com.notsatria.sepathu.ui.theme.TextGrey
import com.notsatria.sepathu.ui.theme.White
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val viewModel: HomeViewModel = koinViewModel()
    val categories = viewModel.shoeCategories

    val selectedCategory by viewModel.chipSelected.collectAsState()
    val shoes by viewModel.shoes.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.setChipSelected(4)
        viewModel.getAllShoes()
    }

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
            items(categories) { category ->
                ShoeCategoryChip(
                    onClick = {
                        if (category.id == 4) {
                            viewModel.getAllShoes()
                        } else {
                            viewModel.getShoesByCategory(category.id)
                        }
                        viewModel.setChipSelected(category.id)
                    },
                    categoryName = category.name,
                    selected = selectedCategory == category.id,
                    modifier = Modifier.padding(start = 16.dp, top = 20.dp)
                )
            }
        }
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(shoes) { shoe ->
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

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFF1E213A)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Preview
@Composable
fun ShoeCategoryChipPreview() {
    ShoeCategoryChip(onClick = {}, categoryName = "Running", selected = true)
}