package com.fatchoy.dollar.feature.transactions

import com.fatchoy.dollar.core.data.expenses.expenseItemCard.ExpenseItemCardViewState

data class TransactionsViewState(
    val isLoading: Boolean = false,
    val transactions: Map<String, List<ExpenseItemCardViewState>>,
    val errorMessage: String? = null
)
