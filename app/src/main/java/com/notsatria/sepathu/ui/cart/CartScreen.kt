package com.notsatria.sepathu.ui.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.notsatria.sepathu.R
import com.notsatria.sepathu.data.entities.ShoeEntity
import com.notsatria.sepathu.ui.commons.UiState
import com.notsatria.sepathu.ui.components.CartItem
import com.notsatria.sepathu.ui.theme.White
import org.koin.androidx.compose.koinViewModel

@Composable
fun CartScreen(modifier: Modifier = Modifier, viewModel: CartViewModel = koinViewModel()) {

    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getShoesOnCart()
            }

            is UiState.Success -> {
                CartContent(modifier, shoes = uiState.data)
            }

            is UiState.Error -> {
                CartEmpty(modifier)
            }
        }
    }
}

@Composable
fun CartContent(
    modifier: Modifier = Modifier,
    shoes: List<ShoeEntity>
) {
    Column(modifier.fillMaxSize()) {
        Text(
            stringResource(R.string.your_cart),
            color = White,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally),
        )

        LazyColumn {
            items(shoes) { shoe ->
                CartItem(
                    shoe = shoe,
                    onRemoveItemClick = {},
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun CartEmpty(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        Text(
            stringResource(R.string.your_cart),
            color = White,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally),
        )
        Text(
            stringResource(R.string.empty_cart),
            color = White,
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, backgroundColor = 0xFF1F1D2B)
@Composable
fun CartScreenPreview() {
    CartScreen()
}