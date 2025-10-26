package com.fatchoy.dollar.feature.budgets.budgetCard

import java.time.LocalDate

data class BudgetCardViewState(
    val budgetTitle: String,
    val budgetAmount: Double,
    val budgetUsed: Double,
    val budgetProgress: Float,
    val budgetResetDate: LocalDate
)
