package com.notsatria.sepathu.ui.home

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.notsatria.sepathu.R
import com.notsatria.sepathu.data.entities.ShoeCategory
import com.notsatria.sepathu.data.entities.ShoeEntity
import com.notsatria.sepathu.ui.commons.UiState
import com.notsatria.sepathu.ui.components.ShoeCategoryChip
import com.notsatria.sepathu.ui.components.ShoeItem
import com.notsatria.sepathu.ui.theme.TextGrey
import com.notsatria.sepathu.ui.theme.White
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit,
    viewModel: HomeViewModel = koinViewModel()
) {

    val categories = viewModel.shoeCategories

    val selectedCategory by viewModel.chipSelected.collectAsStateWithLifecycle()

    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.setChipSelected(4)
                viewModel.getAllShoes()
            }

            is UiState.Success -> {
                HomeContent(
                    modifier = modifier,
                    shoes = uiState.data,
                    categories = categories,
                    selectedCategory = selectedCategory,
                    navigateToDetail = navigateToDetail,
                    viewModel = viewModel,
                )
            }

            is UiState.Error -> {}
        }
    }

}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    shoes: List<ShoeEntity>,
    categories: List<ShoeCategory>,
    selectedCategory: Int,
    navigateToDetail: (Int) -> Unit,
    viewModel: HomeViewModel
) {
    Column(modifier) {
        val context = LocalContext.current
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
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(modifier = Modifier.padding(end = 16.dp)) {
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
                    ShoeItem(shoe = shoe, onAddToCartClick = {
                        viewModel.updateShoeOnCart(shoe.id, !shoe.isOnCart)

                        val message =
                            if (!shoe.isOnCart) context.getString(R.string.added_to_cart) else context.getString(
                                R.string.removed_from_cart
                            )

                        Toast.makeText(
                            context,
                            message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }, modifier = Modifier.clickable {
                        navigateToDetail(shoe.id)
                    })
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
    HomeScreen(navigateToDetail = {})
}

@Preview
@Composable
fun ShoeCategoryChipPreview() {
    ShoeCategoryChip(onClick = {}, categoryName = "Running", selected = true)
}