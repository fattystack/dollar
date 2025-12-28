package com.fatchoy.dollar.core.data.expenseItemCard

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.fatchoy.dollar.ui.theme.DollarTypography
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import com.fatchoy.dollar.ui.theme.DollarTheme
import androidx.compose.ui.tooling.preview.Preview
import com.fatchoy.dollar.R



//TODO: FIX STYLING
@Composable
fun ExpenseItemCardView(
    state: ExpenseItemCardViewState,
    modifier: Modifier = Modifier

) {
    // Implementation of the ExpenseItemCardView goes here

    ElevatedCard() {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            GetCardIcon(
                categoryIcon = state.categoryIcon,
                categoryIconBackground = state.categoryIconBackground
            )
            GetCardText(
                merchantName = state.merchantName,
                categoryName = state.categoryName
            )
            GetCardAmount(
                amountFormatted = state.amountFormatted
            )
        }
    }
}

@Composable
fun GetCardIcon(categoryIcon: Int, categoryIconBackground: Color) {
    Box(
        modifier = Modifier
            .size(56.dp)
            .background(
                color = categoryIconBackground.copy(alpha = 0.2f),
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = categoryIcon),
            contentDescription = null,
            tint = categoryIconBackground,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun GetCardText(merchantName: String, categoryName: String) {
    Column(
    ) {
        Text(
            text = merchantName,
            style = DollarTypography.Body.copy(fontWeight = FontWeight.Medium)
        )
        Text(
            text = categoryName,
            style = DollarTypography.H4_LIGHT
        )
    }
}

@Composable
fun GetCardAmount(amountFormatted: String) {
    Text(
        text = amountFormatted,
        style = DollarTypography.Body.copy(fontWeight = FontWeight.Medium)
    )
}

@Preview(showBackground = true)
@Composable
fun ExpenseItemCardPreview() {
    ExpenseItemCardView(
        state = ExpenseItemCardViewState(
            id = "1",
            merchantName = "Starbucks",
            categoryName = "Dining Out",
            categoryIcon = R.drawable.ic_cart, // just a preview, replace later
            categoryIconBackground = Color(0xFFE57373), // light red
            amount = 5.50,
            amountFormatted = "-$5.50",
            date = "Dec 27"
        )
    )
}