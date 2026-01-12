package com.fatchoy.dollar.core.data.budgetItem

import androidx.compose.ui.graphics.Color
import com.fatchoy.dollar.core.data.expenses.expenseItemCard.ExpenseItemCardViewState

data class BudgetItemViewState(
    val id: String,
    val categoryName: String,
    val categoryIcon: Int,
    val categoryIconBackground: Color,
    val totalSpent: Double,
    val totalSpentFormatted: String,
    val budgetLimit: Double,
    val budgetLimitFormatted: String,
    val progress: Float, // 0.0 to 1.0
    val transactions: List<ExpenseItemCardViewState> = emptyList(),
    val isExpanded: Boolean = false
)
