package com.fatchoy.dollar.core.data.monthlySpentCard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import com.fatchoy.dollar.ui.styling.DollarColors
import com.fatchoy.dollar.ui.styling.DollarSize
import com.fatchoy.dollar.ui.styling.DollarSpace
import com.fatchoy.dollar.ui.theme.DollarTheme
import com.fatchoy.dollar.ui.theme.DollarTypography

@Composable
fun MonthlySpentCardView(
    state: MonthlySpentCardViewState,
    modifier: Modifier = Modifier
) {
    ElevatedCard(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(DollarSpace.L),
            verticalArrangement = Arrangement.spacedBy(DollarSpace.R)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                GetCardTitle()
                GetBudgetSpentText(
                    amountSpent = state.BudgetSpent,
                    budgetAmount = state.TotalBudget
                )
            }
            GetBudgetProgressBar(progress = state.BudgetProgress)
        }
    }
}

@Composable
fun GetCardTitle(modifier: Modifier = Modifier) {
    Text(
        text = "Monthly Spending",
        style = DollarTypography.SECTION_HEADER,
    )
}

@Composable
fun GetBudgetSpentText(modifier: Modifier = Modifier, amountSpent: String, budgetAmount: String){
    Text(
        text = "$amountSpent of $budgetAmount",
        style = DollarTypography.H4_LIGHT
    )
}

@Composable
fun GetBudgetProgressBar(modifier: Modifier = Modifier, progress: Float) {
    var color = DollarColors.MONTHLY_GREEN
    when {
        progress >= 0.9f -> {
            color = DollarColors.MONTHLY_RED
        }
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(DollarSize.ProgressBarHeight)
            .clip(RoundedCornerShape(DollarSize.CornerRadiusXS))
            .background(DollarColors.GRAY.copy(alpha = 0.3f))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(progress.coerceIn(0f, 1f))
                .fillMaxHeight()
                .background(color)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MonthlySpentCardPreview() {
    DollarTheme {
        Column(
            modifier = Modifier.padding(DollarSpace.L),
            verticalArrangement = Arrangement.spacedBy(DollarSpace.R)
        ) {
            // Normal progress
            MonthlySpentCardView(
                state = MonthlySpentCardViewState(
                    BudgetSpent = "$1,200",
                    TotalBudget = "$2,000",
                    BudgetProgress = 0.6f
                )
            )

            // Almost at budget
            MonthlySpentCardView(
                state = MonthlySpentCardViewState(
                    BudgetSpent = "$1,850",
                    TotalBudget = "$2,000",
                    BudgetProgress = 0.925f
                )
            )

            // Over budget
            MonthlySpentCardView(
                state = MonthlySpentCardViewState(
                    BudgetSpent = "$2,450",
                    TotalBudget = "$2,000",
                    BudgetProgress = 1.0f
                )
            )
        }
    }
}
