package com.fatchoy.dollar.core.data.categoryChip

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.fatchoy.dollar.R
import com.fatchoy.dollar.ui.styling.DollarColors
import com.fatchoy.dollar.ui.styling.DollarPadding
import com.fatchoy.dollar.ui.styling.DollarSize
import com.fatchoy.dollar.ui.styling.DollarSpace
import com.fatchoy.dollar.ui.theme.DollarTypography

@Composable
internal fun CategoryChipView(
    state: CategoryChipViewState,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .background(
                color = DollarColors.CATEGORY_COLOR.copy(alpha = 0.15f),
                shape = RoundedCornerShape(DollarSize.CornerRadiusL)
            )
            .padding(horizontal = DollarPadding.S, vertical = DollarPadding.XS),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(DollarSpace.XXS),

    ) {
        GetCategoryIcon(state.categoryIcon)
        GetCategoryText(state.categoryName)
    }
}

@Composable
internal fun GetCategoryIcon(categoryIcon: Int) {
    Icon(
        painter = painterResource(id = categoryIcon),
        contentDescription = null,
        tint = DollarColors.CATEGORY_COLOR,
        modifier = Modifier.size(DollarSize.CategoryIconSize)
    )
}

@Composable
internal fun GetCategoryText(categoryName: String) {
    Text(
        text = categoryName,
        color = DollarColors.CATEGORY_COLOR,
        style = DollarTypography.Body.copy(fontWeight = FontWeight.Light)
    )
}

@Preview()
@Composable
fun CategoryChipPreview() {
    CategoryChipView(
        state = CategoryChipViewState(
            categoryName = "Groceries",
            categoryIcon = R.drawable.ic_cart,
        )
    )
}
