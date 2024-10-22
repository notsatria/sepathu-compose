package com.notsatria.sepathu.ui.search

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.notsatria.sepathu.R
import com.notsatria.sepathu.data.entities.ShoeEntity
import com.notsatria.sepathu.ui.cart.CartEmpty
import com.notsatria.sepathu.ui.commons.UiState
import com.notsatria.sepathu.ui.components.HorizontalShoeItem
import com.notsatria.sepathu.ui.theme.White
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen(modifier: Modifier = Modifier, viewModel: SearchViewModel = koinViewModel()) {

    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.searchShoes()
            }

            is UiState.Success -> {
                SearchContent(modifier = modifier, shoes = uiState.data, viewModel = viewModel)
            }

            is UiState.Error -> {
                Log.e("SearchScreen", "SearchScreen: ${uiState.errorMessage}")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchContent(
    modifier: Modifier = Modifier,
    shoes: List<ShoeEntity>,
    viewModel: SearchViewModel
) {
    Column(modifier) {

        Text(
            stringResource(R.string.search),
            color = White,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally),
        )
        TextField(
            value = viewModel.searchQuery,
            onValueChange = { text ->
                viewModel.updateQuery(text)
                viewModel.searchShoes(text)
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
            },
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            keyboardActions = KeyboardActions(onSearch = {
                viewModel.searchShoes(viewModel.searchQuery)
            }),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        if (shoes.isEmpty()) {
            CartEmpty()
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
            ) {
                items(shoes) { shoe ->
                    HorizontalShoeItem(shoe = shoe)
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}
