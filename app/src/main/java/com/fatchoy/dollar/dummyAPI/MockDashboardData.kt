package com.fatchoy.dollar.dummyAPI

import com.fatchoy.dollar.R
import com.fatchoy.dollar.core.data.categoryChip.CategoryChipViewState
import com.fatchoy.dollar.core.data.expenses.ExpensesViewState
import com.fatchoy.dollar.core.data.expenses.expenseItemCard.ExpenseItemCardViewState
import com.fatchoy.dollar.core.data.expenses.expenseSummaryCard.ExpenseSummaryCardViewState
import com.fatchoy.dollar.core.data.monthlySpentCard.MonthlySpentCardViewState
import com.fatchoy.dollar.core.data.user.UserViewState
import com.fatchoy.dollar.core.ui.user.UserUI
import com.fatchoy.dollar.feature.dashboard.DashboardViewState
import com.fatchoy.dollar.ui.styling.DollarColors

object MockDashboardData {

    private val mockUser = UserViewState.Authenticated(
        user = UserUI(
            id = "u-123",
            userName = "John Doe",
            avatarUrl = null
        )
    )

    private val mockExpenses = ExpensesViewState(
        userHeader = ExpensesViewState.UserHeader(displayName = "John"),
        recentExpenses = listOf(
            ExpensesViewState.ExpenseItem(
                id = "1",
                merchant = "Starbucks",
                categoryName = "Dining Out",
                amount = 5.50,
                amountFormatted = "-$5.50",
                expenseDate = "Dec 27",
                accountLabel = "Checking"
            ),
            ExpensesViewState.ExpenseItem(
                id = "2",
                merchant = "Shell Gas",
                categoryName = "Transportation",
                amount = 45.00,
                amountFormatted = "-$45.00",
                expenseDate = "Dec 26",
                accountLabel = "Credit Card"
            )
        ),
        monthlySpent = 1250.50,
        monthlyBudget = 2000.00,
        monthProgress = 0.625f,
        isRefreshing = false,
        error = null
    )

    private val mockExpenseSummary = ExpenseSummaryCardViewState(
        title = "Total Balance",
        moneySpent = 15250.80,
        comparisonAmount = 150.30,
        comparisonDirection = 2,
        isLoading = false
    )

    private val mockMonthlySpent = MonthlySpentCardViewState(
        budgetSpent = "$1,200",
        totalBudget = "$2,000",
        budgetProgress = 0.6f
    )

    val mockCategories = listOf(
        CategoryChipViewState(categoryName = "Groceries", categoryIcon = R.drawable.ic_cart),
        CategoryChipViewState(categoryName = "Shopping", categoryIcon = R.drawable.ic_cart),
        CategoryChipViewState(categoryName = "Dining Out", categoryIcon = R.drawable.ic_cart),
        CategoryChipViewState(categoryName = "Transport", categoryIcon = R.drawable.ic_cart)
    )

    private val mockRecentExpenses = listOf(
        ExpenseItemCardViewState(
            id = "1",
            merchantName = "Starbucks",
            categoryName = "Dining Out",
            categoryIcon = R.drawable.ic_cart,
            categoryIconBackground = DollarColors.MOCK_EXPENSE_RED,
            amount = 5.50,
            amountFormatted = "-$5.50",
            date = "Dec 27"
        ),
        ExpenseItemCardViewState(
            id = "2",
            merchantName = "Uber",
            categoryName = "Transport",
            categoryIcon = R.drawable.ic_cart,
            categoryIconBackground = DollarColors.MOCK_EXPENSE_BLUE,
            amount = 24.10,
            amountFormatted = "-$24.10",
            date = "Dec 26"
        ),
        ExpenseItemCardViewState(
            id = "3",
            merchantName = "Whole Foods",
            categoryName = "Groceries",
            categoryIcon = R.drawable.ic_cart,
            categoryIconBackground = DollarColors.MOCK_EXPENSE_GREEN,
            amount = 112.80,
            amountFormatted = "-$112.80",
            date = "Dec 25"
        ),
        ExpenseItemCardViewState(
            id = "4",
            merchantName = "Whole Foods",
            categoryName = "Groceries",
            categoryIcon = R.drawable.ic_cart,
            categoryIconBackground = DollarColors.MOCK_EXPENSE_RED,
            amount = 112.80,
            amountFormatted = "-$112.80",
            date = "Dec 25"
        ),
        ExpenseItemCardViewState(
            id = "5",
            merchantName = "Whole Foods",
            categoryName = "Groceries",
            categoryIcon = R.drawable.ic_cart,
            categoryIconBackground = DollarColors.MOCK_EXPENSE_BLUE,
            amount = 112.80,
            amountFormatted = "-$112.80",
            date = "Dec 25"
        ),
        ExpenseItemCardViewState(
            id = "6",
            merchantName = "Whole Foods",
            categoryName = "Groceries",
            categoryIcon = R.drawable.ic_cart,
            categoryIconBackground = DollarColors.MOCK_EXPENSE_GREEN,
            amount = 112.80,
            amountFormatted = "-$112.80",
            date = "Dec 25"
        )
    )

    val mockDashboardState = DashboardViewState(
        user = mockUser,
        expenses = mockExpenses,
        expenseSummaryCardState = mockExpenseSummary,
        monthlySpentCardViewState = mockMonthlySpent,
        frequentCategories = mockCategories,
        recentExpenses = mockRecentExpenses,
        isLoading = false,
        error = null
    )
}
