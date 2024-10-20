package com.notsatria.sepathu.ui.detail

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.notsatria.sepathu.R
import com.notsatria.sepathu.data.entities.ShoeEntity
import com.notsatria.sepathu.data.entities.getCategoryName
import com.notsatria.sepathu.ui.commons.UiState
import com.notsatria.sepathu.ui.components.ImagePager
import com.notsatria.sepathu.ui.theme.Blue
import com.notsatria.sepathu.ui.theme.DarkNavy
import com.notsatria.sepathu.ui.theme.Indigo
import com.notsatria.sepathu.ui.theme.Purple
import com.notsatria.sepathu.ui.theme.TextDisabled
import com.notsatria.sepathu.ui.theme.TextGrey
import com.notsatria.sepathu.ui.theme.White
import com.notsatria.sepathu.utils.convertToDollar
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    shoeId: Int,
    navigateBack: () -> Unit = {},
    viewModel: DetailViewModel = koinViewModel()
) {

    val pagerState = rememberPagerState {
        3
    }

    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getShoeById(shoeId)
            }

            is UiState.Success -> {
                DetailContent(
                    modifier = modifier,
                    shoe = uiState.data,
                    pagerState = pagerState,
                    navigateBack = navigateBack
                )
            }

            is UiState.Error -> {}
        }
    }
}

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    shoe: ShoeEntity,
    pagerState: PagerState,
    navigateBack: () -> Unit
) {
    val context = LocalContext.current
    Box {
        Column(
            modifier = modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
        ) {
            ImagePager(pagerState = pagerState, navigateBack = navigateBack)

            Column(
                modifier = Modifier
                    .background(color = DarkNavy)
                    .padding(20.dp)
            ) {
                Text(
                    text = shoe.name.uppercase(),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = White
                )
                Text(
                    text = getCategoryName(shoe.categoryId),
                    fontSize = 14.sp,
                    color = TextGrey,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .background(color = Indigo, shape = RoundedCornerShape(4.dp))
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.price_starts_from),
                        color = White,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = shoe.price.convertToDollar(),
                        color = Blue,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = stringResource(R.string.description),
                    fontSize = 14.sp,
                    color = White
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = shoe.description,
                    fontSize = 14.sp,
                    color = TextDisabled
                )
            }
        }
        Spacer(modifier = Modifier.height(80.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = DarkNavy)
                .align(Alignment.BottomCenter)
                .padding(top = 20.dp, start = 20.dp, end = 16.dp)
        ) {
            IconButton(
                onClick = { Toast.makeText(context,
                    context.getString(R.string.coming_soon), Toast.LENGTH_SHORT).show() },
                modifier = Modifier.border(
                    width = 1.dp,
                    color = Purple,
                    shape = RoundedCornerShape(12.dp)
                )
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.Message,
                    contentDescription = "Message",
                    tint = Purple
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {},
                colors = ButtonColors(
                    contentColor = White,
                    containerColor = Purple,
                    disabledContentColor = TextDisabled,
                    disabledContainerColor = Purple
                ),
                shape = RoundedCornerShape(12.dp),
                contentPadding = PaddingValues(vertical = 12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(R.string.add_to_cart))
            }
        }
    }
}


@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen(shoeId = 1, navigateBack = {})
}