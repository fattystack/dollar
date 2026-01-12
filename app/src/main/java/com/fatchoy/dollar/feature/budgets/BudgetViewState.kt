package com.fatchoy.dollar.feature.budgets

import com.fatchoy.dollar.core.data.budgetItem.BudgetItemViewState

data class BudgetViewState(
    val budgets: List<BudgetItemViewState> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
