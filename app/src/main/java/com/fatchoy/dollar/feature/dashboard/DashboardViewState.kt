package com.fatchoy.dollar.feature.dashboard

import com.fatchoy.dollar.core.data.categoryChip.CategoryChipViewState
import com.fatchoy.dollar.core.data.expenses.ExpensesViewState
import com.fatchoy.dollar.core.data.expenses.expenseItemCard.ExpenseItemCardViewState
import com.fatchoy.dollar.core.data.expenses.expenseSummaryCard.ExpenseSummaryCardViewState
import com.fatchoy.dollar.core.data.monthlySpentCard.MonthlySpentCardViewState
import com.fatchoy.dollar.core.data.user.UserViewState

data class DashboardViewState(
    val user: UserViewState,
    val expenses: ExpensesViewState,
    val expenseSummaryCardState: ExpenseSummaryCardViewState,
    val monthlySpentCardViewState: MonthlySpentCardViewState,
    val frequentCategories: List<CategoryChipViewState>,
    val recentExpenses: List<ExpenseItemCardViewState>,
    val isLoading: Boolean = true,
    val error: String? = null
)
