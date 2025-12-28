package com.fatchoy.dollar.feature.dashboard.expenseSummaryCard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fatchoy.dollar.R
import com.fatchoy.dollar.core.util.formatCurrency
import com.fatchoy.dollar.core.util.formatDelta
import com.fatchoy.dollar.ui.styling.ExpenseCardTokens
import com.fatchoy.dollar.ui.styling.Semantic
import com.fatchoy.dollar.ui.styling.expenseCardColours
import com.fatchoy.dollar.ui.styling.trendColor
import com.fatchoy.dollar.ui.theme.DollarTypography

@Composable
internal fun ExpenseSummaryCardView(state: ExpenseSummaryCardViewState, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(ExpenseCardTokens.Corner),
        colors = expenseCardColours(),
        elevation = CardDefaults.cardElevation(ExpenseCardTokens.Elevation)
    ) {
        Column(Modifier.padding(ExpenseCardTokens.Padding)) {
            Text(
                text = state.title.orEmpty(),
                style = DollarTypography.Body,
                color = Semantic.TextSubheader
            )
            Spacer(Modifier.height(6.dp))
            GetMonthlyExpenses(state.moneySpent)
            Spacer(Modifier.height(10.dp))
            GetMonthlyComparison(state.comparisonAmount, state.comparisonDirection)
        }
    }
}

@Composable
internal fun GetMonthlyExpenses(moneySpent: Double) {
    Text(
        text = formatCurrency(moneySpent),
        style = DollarTypography.H1
    )
}

@Composable
internal fun GetMonthlyComparison(moneyComparison: Double, comparisonDirection: Int) {
    val trendColor = trendColor(comparisonDirection)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Icon(
            painter = getIcon(comparisonDirection),
            contentDescription = "Expense Trend Comparison Icons",
            tint = trendColor
        )
        Text(
            text = "${formatDelta(moneyComparison)} this month",
            style = DollarTypography.Body,
            color = trendColor
        )
    }
}

@Composable
internal fun getIcon(direction: Int): Painter {
    return when (direction) {
        // up
        1 -> painterResource(R.drawable.down_trend_icon)
        // down
        2 -> painterResource(R.drawable.up_trend_icon)
        // neutral
        else -> painterResource(R.drawable.neutral_trend_icon)
    }
}
