package com.fatchoy.dollar.core.data.expenseItemCard

import androidx.compose.ui.graphics.Color

data class ExpenseItemCardViewState(
    val id: String,
    val merchantName: String,
    val categoryName: String,
    val categoryIcon: Int,
    val categoryIconBackground: Color,
    val amount: Double,
    val amountFormatted: String,
    val date: String? = null
)