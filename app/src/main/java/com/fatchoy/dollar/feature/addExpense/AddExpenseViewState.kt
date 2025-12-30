package com.fatchoy.dollar.feature.addExpense

import com.fatchoy.dollar.core.data.categoryChip.CategoryChipViewState

data class AddExpenseViewState(
    val expenseAmount: Double? = null,
    val expenseCategories: List<CategoryChipViewState>,
    val expenseNote: String,
)
