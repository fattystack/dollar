package com.fatchoy.dollar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.fatchoy.dollar.ui.styling.DollarColors
import com.fatchoy.dollar.ui.styling.DollarSize
import com.fatchoy.dollar.ui.styling.DollarSpace
import com.fatchoy.dollar.ui.styling.DollarWidth
import com.fatchoy.dollar.ui.theme.DollarTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    onProfileClick: () -> Unit = {},
) {
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = DollarColors.APP_BACKGROUND_COLOR
        ),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(DollarSpace.S),
            ) {
                Box(
                    modifier = Modifier
                        .size(DollarWidth.XXL)
                        .clip(CircleShape)
                        .border(DollarWidth.XXS, DollarColors.GREEN, CircleShape)
                        .background(Color.White),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "$",
                        style = DollarTypography.H2.copy(
                            color = DollarColors.GREEN,
                            fontWeight = FontWeight.ExtraBold
                        )
                    )
                }
                Text(
                    text = "Dollar",
                    style = DollarTypography.H2.copy(
                        color = DollarColors.GREEN
                    )
                )
            }
        },

        actions = {
            // user avatar
            Box(
                modifier = Modifier
                    .size(DollarWidth.XXL)
                    .clip(CircleShape)
                    .background(DollarColors.APP_BACKGROUND_COLOR)
                    .clickable(onClick = onProfileClick),
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "User Profile",
                    tint = DollarColors.GREEN,
                    modifier = Modifier.size(DollarSize.IconXLarge)
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DollarTopBarPreview() {
    TopBar(
        onProfileClick = {}
    )
}
