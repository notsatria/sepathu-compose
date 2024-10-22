package com.notsatria.sepathu.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.notsatria.sepathu.R
import com.notsatria.sepathu.data.entities.ShoeEntity
import com.notsatria.sepathu.ui.theme.Blue
import com.notsatria.sepathu.ui.theme.DotIndicatorDefault
import com.notsatria.sepathu.ui.theme.Grey
import com.notsatria.sepathu.ui.theme.Purple
import com.notsatria.sepathu.ui.theme.Red
import com.notsatria.sepathu.ui.theme.SoftBlack
import com.notsatria.sepathu.ui.theme.White
import com.notsatria.sepathu.utils.DataDummy
import com.notsatria.sepathu.utils.convertToDollar

@Composable
fun HorizontalShoeItem(
    modifier: Modifier = Modifier,
    shoe: ShoeEntity,
    onCartClicked: () -> Unit = {},
    onItemClicked: () -> Unit = {}
) {
    Card(
        modifier.clickable {
            onItemClicked()
        },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = SoftBlack)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = shoe.image),
                    contentDescription = shoe.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
                Column(
                    modifier = Modifier
                        .padding(start = 12.dp, end = 12.dp)
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                ) {
                    Text(
                        text = shoe.name,
                        fontWeight = FontWeight.SemiBold,
                        color = White,
                        fontSize = 14.sp,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = shoe.price.convertToDollar(),
                        fontWeight = FontWeight.Normal,
                        color = Blue,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                }
                IconButton(
                    onClick = onCartClicked,
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
}

@Preview
@Composable
fun HorizontalShoeItemPreview() {
    HorizontalShoeItem(
        shoe = DataDummy.generateDummyShoe()[2],
        onCartClicked = {}
    )
}