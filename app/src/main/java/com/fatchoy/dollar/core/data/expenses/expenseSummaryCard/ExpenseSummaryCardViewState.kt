package com.fatchoy.dollar.core.data.expenses.expenseSummaryCard

data class ExpenseSummaryCardViewState(
    val title: String? = "This Month's Spending",
    val moneySpent: Double,
    val comparisonAmount: Double = 0.00,
    val comparisonDirection: Int = 0,
    val isLoading: Boolean,
    val error: String? = null
)
