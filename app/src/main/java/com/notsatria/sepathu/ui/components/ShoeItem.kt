package com.notsatria.sepathu.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.notsatria.sepathu.R
import com.notsatria.sepathu.data.entities.ShoeEntity
import com.notsatria.sepathu.data.entities.getCategoryName
import com.notsatria.sepathu.ui.theme.Blue
import com.notsatria.sepathu.ui.theme.DotIndicatorDefault
import com.notsatria.sepathu.ui.theme.Purple
import com.notsatria.sepathu.ui.theme.TextBlack
import com.notsatria.sepathu.ui.theme.TextGrey
import com.notsatria.sepathu.ui.theme.White
import com.notsatria.sepathu.utils.DataDummy
import com.notsatria.sepathu.utils.convertToDollar

@Composable
fun ShoeItem(modifier: Modifier = Modifier, shoe: ShoeEntity, onAddToCartClick: () -> Unit = {}) {
    Card(
        modifier
            .width(215.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardColors(
            containerColor = White,
            contentColor = White,
            disabledContainerColor = White,
            disabledContentColor = White
        )
    ) {
        Box {
            Column {
                Image(
                    painter = painterResource(id = shoe.image),
                    contentDescription = shoe.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                        .height(140.dp)
                )
                Text(
                    text = getCategoryName(shoe.categoryId),
                    fontSize = 14.sp,
                    color = TextGrey,
                    modifier = modifier.padding(start = 20.dp, top = 12.dp)
                )
                Text(
                    text = shoe.name.uppercase(),
                    fontSize = 18.sp,
                    color = TextBlack,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    modifier = modifier.padding(start = 20.dp, top = 4.dp, end = 20.dp)
                )
                Text(
                    text = shoe.price.convertToDollar(),
                    fontSize = 16.sp,
                    color = Blue,
                    fontWeight = FontWeight.SemiBold,
                    modifier = modifier.padding(
                        start = 20.dp,
                        top = 2.dp,
                        end = 20.dp,
                        bottom = 12.dp
                    )
                )
            }
            IconButton(
                onClick = onAddToCartClick,
                modifier = Modifier
                    .zIndex(2f)
                    .align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = if (shoe.isOnCart) Icons.Default.ShoppingCart else Icons.Outlined.ShoppingCart,
                    contentDescription = stringResource(
                        id = R.string.add_to_cart
                    ),
                    tint = if (shoe.isOnCart) Purple else DotIndicatorDefault,
                )
            }
        }
    }
}

@Preview
@Composable
fun ShoeItemPreview() {
    ShoeItem(shoe = DataDummy.generateDummyShoe()[1])
}