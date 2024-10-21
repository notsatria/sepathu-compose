package com.notsatria.sepathu.ui.cart

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
    val context = LocalContext.current

    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getShoesOnCart()
            }

            is UiState.Success -> {
                CartContent(
                    modifier,
                    shoes = uiState.data,
                    removeItem = { shoe ->
                        viewModel.removeShoesFromCart(shoe.id)
                        Toast.makeText(
                            context,
                            context.getString(R.string.removed_from_cart),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
            }

            is UiState.Error -> {
                Log.e("CartScreen", "CartScreen: ${uiState.errorMessage}", )
            }
        }
    }
}

@Composable
fun CartContent(
    modifier: Modifier = Modifier,
    shoes: List<ShoeEntity>,
    removeItem: (ShoeEntity) -> Unit = {},
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

        if (shoes.isEmpty()) {
            CartEmpty(Modifier.fillMaxSize())
        } else {
            LazyColumn {
                items(shoes) { shoe ->
                    CartItem(
                        shoe = shoe, onRemoveItemClick = {
                            removeItem(shoe)
                        },
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}

@Composable
fun CartEmpty(modifier: Modifier = Modifier) {
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_cart),
            contentDescription = "Cart",
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            stringResource(R.string.empty_cart),
            color = White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview()
@Composable
fun CartScreenPreview() {
    CartEmpty()
}