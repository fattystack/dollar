package com.fatchoy.dollar.core.data.expenses

data class ExpensesViewState(
    val userHeader: UserHeader,
    val recentExpenses: List<ExpenseItem> = emptyList(),
    val monthlySpent: Double = 0.00,
    val monthlyBudget: Double = 0.00,
    val monthProgress: Float = 0f,
    val isRefreshing: Boolean = false,
    val error: String? = null
) {
    data class ExpenseItem(
        val id: String,
        val merchant: String,
        val categoryName: String,
        val amount: Double = 0.00,
        val amountFormatted: String,
        val expenseDate: String,
        val accountLabel: String
    )
    data class UserHeader(val displayName: String)
}
