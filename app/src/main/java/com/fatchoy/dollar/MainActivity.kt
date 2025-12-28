package com.fatchoy.dollar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fatchoy.dollar.core.data.expenses.ExpensesViewState
import com.fatchoy.dollar.core.data.user.UserViewState
import com.fatchoy.dollar.core.ui.user.UserUI
import com.fatchoy.dollar.feature.dashboard.DashboardView
import com.fatchoy.dollar.feature.dashboard.DashboardViewState
import com.fatchoy.dollar.feature.dashboard.expenseSummaryCard.ExpenseSummaryCardViewState
import com.fatchoy.dollar.ui.theme.DollarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DollarApp()
        }
    }
}

@Composable
fun DollarApp() {
    val navController = rememberNavController()

    Scaffold(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = "dashboard",
            modifier = Modifier.padding(it)
        ) {
            // Define your composable destinations here
            composable("dashboard") {
                val dashboardState = DashboardViewState(
                    user = UserViewState.Authenticated(
                        user = UserUI(
                            id = "u-123",
                            userName = "John Doe",
                            avatarUrl = null
                        )
                    ),
                    expenses = ExpensesViewState(
                        userHeader = ExpensesViewState.UserHeader(
                            displayName = "John"
                        ),
                        recentExpenses = listOf(
                            ExpensesViewState.ExpenseItem(
                                id = "1",
                                merchant = "Starbucks",
                                categoryName = "Food & Drink",
                                amount = 5.50,
                                amountFormatted = "$5.50",
                                expenseDate = "Dec 27",
                                accountLabel = "Checking"
                            ),
                            ExpensesViewState.ExpenseItem(
                                id = "2",
                                merchant = "Shell Gas",
                                categoryName = "Transportation",
                                amount = 45.00,
                                amountFormatted = "$45.00",
                                expenseDate = "Dec 26",
                                accountLabel = "Credit Card"
                            )
                        ),
                        monthlySpent = 1250.50,
                        monthlyBudget = 2000.00,
                        monthProgress = 0.625f,
                        isRefreshing = false,
                        error = null
                    ),
                    expenseSummaryCardState = ExpenseSummaryCardViewState(
                        title = "Monthly Spending",
                        moneySpent = 1250.50,
                        comparisonAmount = 150.0,
                        comparisonDirection = 2,
                        isLoading = false,
                    ),
                    isLoading = false,
                    error = null
                )

                DashboardView(viewState = dashboardState)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DollarTheme {
        Greeting("Android")
    }
}
