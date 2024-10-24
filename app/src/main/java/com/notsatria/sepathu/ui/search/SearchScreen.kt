package com.notsatria.sepathu.ui.search

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.notsatria.sepathu.R
import com.notsatria.sepathu.data.entities.ShoeEntity
import com.notsatria.sepathu.ui.commons.UiState
import com.notsatria.sepathu.ui.components.EmptyState
import com.notsatria.sepathu.ui.components.HorizontalShoeItem
import com.notsatria.sepathu.ui.theme.White
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = koinViewModel(),
    navigateToDetail: (Int) -> Unit
) {

    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.searchShoes()
            }

            is UiState.Success -> {
                SearchContent(
                    modifier = modifier,
                    shoes = uiState.data,
                    viewModel = viewModel,
                    navigateToDetail = navigateToDetail
                )
            }

            is UiState.Error -> {
                Log.e("SearchScreen", "SearchScreen: ${uiState.errorMessage}")
            }
        }
    }
}

@Composable
fun SearchContent(
    modifier: Modifier = Modifier,
    shoes: List<ShoeEntity>,
    viewModel: SearchViewModel,
    navigateToDetail: (Int) -> Unit
) {
    val context = LocalContext.current

    Column(modifier.fillMaxSize()) {
        Text(
            stringResource(R.string.search),
            color = White,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally),
        )
        SearchTextField(
            value = viewModel.searchQuery,
            onValueChange = { text ->
                viewModel.updateQuery(text)
                viewModel.searchShoes(text)
            },
            onSearchAction = {
                viewModel.searchShoes(viewModel.searchQuery)
            })
        if (shoes.isEmpty()) {
            EmptyState(
                modifier = Modifier.fillMaxSize(),
                imageResource = R.drawable.ic_search_off,
                stringResource = R.string.empty_search
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
            ) {
                items(shoes) { shoe ->
                    HorizontalShoeItem(
                        shoe = shoe,
                        onItemClicked = {
                            navigateToDetail(shoe.id)
                        },
                        onCartClicked = {
                            viewModel.updateShoeOnCart(shoe.id, !shoe.isOnCart)
                            val message = if (shoe.isOnCart) {
                                context.getString(R.string.remove_from_cart)
                            } else {
                                context.getString(R.string.added_to_cart)
                            }
                            Toast.makeText(
                                context,
                                message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    onSearchAction: () -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        },
        singleLine = true,
        shape = CircleShape,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardActions = KeyboardActions(onSearch = {
            onSearchAction()
        }),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}