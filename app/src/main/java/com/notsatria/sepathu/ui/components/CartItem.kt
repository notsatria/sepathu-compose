package com.notsatria.sepathu.ui.components

import androidx.compose.foundation.Image
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
import androidx.compose.runtime.mutableStateOf
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
import com.notsatria.sepathu.R
import com.notsatria.sepathu.data.entities.ShoeEntity
import com.notsatria.sepathu.ui.theme.Blue
import com.notsatria.sepathu.ui.theme.Grey
import com.notsatria.sepathu.ui.theme.Purple
import com.notsatria.sepathu.ui.theme.Red
import com.notsatria.sepathu.ui.theme.SoftBlack
import com.notsatria.sepathu.ui.theme.White
import com.notsatria.sepathu.utils.DataDummy
import com.notsatria.sepathu.utils.convertToDollar

@Composable
fun CartItem(
    modifier: Modifier = Modifier,
    shoe: ShoeEntity,
    onRemoveItemClick: () -> Unit = {},
) {
    var qty by remember {
        mutableIntStateOf(0)
    }

    Card(
        modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = SoftBlack)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(top = 10.dp)
        ) {
            Row {
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
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.height(IntrinsicSize.Max),
                ) {
                    IconButton(
                        onClick = {
                            qty++
                        },
                        colors = IconButtonColors(
                            containerColor = Purple,
                            contentColor = White,
                            disabledContainerColor = Purple,
                            disabledContentColor = White
                        ),
                        modifier = Modifier.size(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add Item",
                            tint = White,
                            modifier = Modifier
                        )
                    }
                    Text(
                        text = qty.toString(),
                        fontWeight = FontWeight.SemiBold,
                        color = White,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                    IconButton(
                        onClick = {
                            if (qty > 0) {
                                qty--
                            }
                        },
                        colors = IconButtonColors(
                            containerColor = Grey,
                            contentColor = White,
                            disabledContainerColor = Grey,
                            disabledContentColor = White
                        ),
                        modifier = Modifier.size(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Remove,
                            contentDescription = "Decrease Item",
                            tint = White,
                            modifier = Modifier
                        )
                    }
                }
            }
            TextButton(
                onClick = onRemoveItemClick,
                colors = ButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Red,
                    disabledContentColor = Red,
                    disabledContainerColor = Color.Transparent
                )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_trash),
                        contentDescription = "Remove Item"
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = stringResource(id = R.string.remove), fontWeight = FontWeight(400))
                }
            }
        }
    }
}

@Preview
@Composable
fun CartItemPreview() {
    CartItem(
        shoe = DataDummy.generateDummyShoe()[2],
        onRemoveItemClick = {}
    )
}