package com.fatchoy.dollar.dummyAPI

import com.fatchoy.dollar.R
import com.fatchoy.dollar.core.data.budgetItem.BudgetItemViewState
import com.fatchoy.dollar.core.data.expenses.expenseItemCard.ExpenseItemCardViewState
import com.fatchoy.dollar.ui.styling.DollarColors

object MockBudgetData {
    val mockBudgets = listOf(
        BudgetItemViewState(
            id = "1",
            categoryName = "Groceries",
            categoryIcon = R.drawable.ic_cart,
            categoryIconBackground = DollarColors.MOCK_EXPENSE_GREEN,
            totalSpent = 287.45,
            totalSpentFormatted = "-$287.45",
            budgetLimit = 400.00,
            budgetLimitFormatted = "$400.00",
            progress = 0.72f,
            transactions = listOf(
                ExpenseItemCardViewState(
                    id = "1",
                    merchantName = "Whole Foods",
                    categoryName = "Groceries",
                    categoryIcon = R.drawable.ic_cart,
                    categoryIconBackground = DollarColors.MOCK_EXPENSE_GREEN,
                    amount = 54.21,
                    amountFormatted = "-$54.21",
                    date = "Today"
                ),
                ExpenseItemCardViewState(
                    id = "2",
                    merchantName = "Trader Joe's",
                    categoryName = "Groceries",
                    categoryIcon = R.drawable.ic_cart,
                    categoryIconBackground = DollarColors.MOCK_EXPENSE_GREEN,
                    amount = 112.80,
                    amountFormatted = "-$112.80",
                    date = "Yesterday"
                )
            )
        ),
        BudgetItemViewState(
            id = "2",
            categoryName = "Transport",
            categoryIcon = R.drawable.ic_cart,
            categoryIconBackground = DollarColors.MOCK_EXPENSE_BLUE,
            totalSpent = 88.50,
            totalSpentFormatted = "-$88.50",
            budgetLimit = 150.00,
            budgetLimitFormatted = "$150.00",
            progress = 0.59f,
            transactions = emptyList()
        )
    )
}
