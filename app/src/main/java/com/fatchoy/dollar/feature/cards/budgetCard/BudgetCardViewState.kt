package com.fatchoy.dollar.feature.cards.budgetCard

import java.time.LocalDate

internal class BudgetCardViewState(
    val budgetTitle: String,
    val budgetAmount: Double,
    val budgetUsed: Double,
    val budgetProgress: Float,
    val budgetResetDate: LocalDate
)
