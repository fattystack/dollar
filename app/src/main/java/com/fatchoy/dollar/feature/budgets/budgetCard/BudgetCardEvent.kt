package com.fatchoy.dollar.feature.budgets.budgetCard

sealed class BudgetCardEvent {
    data class BudgetReset(val title: String) : BudgetCardEvent()
}
