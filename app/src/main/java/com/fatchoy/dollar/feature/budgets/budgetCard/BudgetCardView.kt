package com.fatchoy.dollar.feature.budgets.budgetCard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fatchoy.dollar.R
import com.fatchoy.dollar.ui.components.BudgetProgressBarModelMaker
import com.fatchoy.dollar.ui.styling.DollarColors
import com.fatchoy.dollar.ui.styling.DollarElevation
import com.fatchoy.dollar.ui.styling.DollarPadding
import com.fatchoy.dollar.ui.styling.DollarSpace
import com.fatchoy.dollar.ui.theme.DollarTypography
import java.time.Clock
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@Composable
internal fun BudgetCardView(viewState: BudgetCardViewState) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = DollarElevation.R),
    ) {
        Column(
            modifier = Modifier.padding(vertical = DollarPadding.S, horizontal = DollarPadding.XL),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(DollarSpace.XS)
        ) {
            Box(modifier = Modifier.size(160.dp)) {
                BudgetProgressBarModelMaker(
                    progress = viewState.budgetProgress,
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(DollarSpace.S),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BudgetTitleText(viewState.budgetTitle)
                BudgetAmountText(viewState.budgetUsed, viewState.budgetAmount)
                BudgetResetTime(viewState.budgetResetDate)
            }
        }
    }
}

@Composable
internal fun BudgetTitleText(title: String) {
    Text(
        text = title,
        style = DollarTypography.H2
    )
}

@Composable
internal fun BudgetAmountText(used: Double, amount: Double) {
    Text(
        text = stringResource(R.string.budget_used_to_amount_ratio, used.toString(), amount.toString()),
        style = DollarTypography.Body
    )
}

@Composable
internal fun BudgetResetTime(date: LocalDate, clock: Clock = Clock.systemDefaultZone()) {
    val today = LocalDate.now(clock)
    val remainingDays: Int = getRemainingDays(date, today).toInt()
    Text(
        text = pluralStringResource(R.plurals.budget_resets_in_days, remainingDays, remainingDays.toString()),
        style = DollarTypography.Body,
        color = DollarColors.BLACK.copy(alpha = 0.4f)
    )
}

internal fun getRemainingDays(date1: LocalDate, date2: LocalDate): Long {
    return ChronoUnit.DAYS.between(date2, date1)
}

const val PREVIEW_DAYS_UNTIL_RESET = 15

@Preview
@Composable
internal fun BudgetCardViewPreview() {
    BudgetCardView(
        BudgetCardViewState(
            budgetTitle = "Groceries",
            budgetAmount = 500.00,
            budgetUsed = 200.00,
            budgetProgress = 0.4f,
            budgetResetDate = LocalDate.now().plusDays(PREVIEW_DAYS_UNTIL_RESET.toLong())
        )
    )
}
