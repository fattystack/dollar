package com.fatchoy.dollar.feature.dashboard

import com.fatchoy.dollar.core.data.expenses.ExpensesViewState
import com.fatchoy.dollar.core.data.user.UserViewState
import com.fatchoy.dollar.core.data.expenseSummaryCard.ExpenseSummaryCardViewState

data class DashboardViewState(
    val user: UserViewState,
    val expenses: ExpensesViewState,
    val expenseSummaryCardState: ExpenseSummaryCardViewState,
    val isLoading: Boolean = true,
    val error: String? = null
)
