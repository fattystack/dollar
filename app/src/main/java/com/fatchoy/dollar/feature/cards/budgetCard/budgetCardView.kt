package com.fatchoy.dollar.feature.cards.budgetCard

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.tooling.preview.Preview
import com.fatchoy.dollar.R
import com.fatchoy.dollar.ui.components.BudgetProgressBarModelMaker
import com.fatchoy.dollar.ui.theme.DollarTypography
import java.time.*
import java.time.temporal.ChronoUnit

@Composable
internal fun BudgetCardView(viewState: BudgetCardViewState) {
    Card {
        Column {
            BudgetProgressBarModelMaker(progress = viewState.budgetProgress)
            BudgetTitleText(viewState.budgetTitle)
            BudgetAmountText(viewState.budgetUsed, viewState.budgetAmount)
            BudgetResetTime(viewState.budgetResetDate)
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
internal fun BudgetAmountText(used: Double, amount: Double){
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
        text = pluralStringResource(R.plurals.budget_resets_in_days, remainingDays, remainingDays.toString())
    )
}

internal fun getRemainingDays(date1: LocalDate, date2: LocalDate): Long {
    return ChronoUnit.DAYS.between(date1, date2)
}

@Preview
@Composable
internal fun BudgetCardViewPreview() {
    BudgetCardView(
        BudgetCardViewState(
            budgetTitle = "Groceries",
            budgetAmount = 500.00,
            budgetUsed = 200.00,
            budgetProgress = 0.4f,
            budgetResetDate = LocalDate.now().plusDays(15)
        )
    )
}