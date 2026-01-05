package com.fatchoy.dollar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fatchoy.dollar.dummyAPI.MockDashboardData
import com.fatchoy.dollar.feature.addExpense.AddExpenseView
import com.fatchoy.dollar.feature.addExpense.AddExpenseViewState
import com.fatchoy.dollar.feature.dashboard.DashboardView
import com.fatchoy.dollar.ui.components.AddExpenseButton
import com.fatchoy.dollar.ui.components.TopBar
import com.fatchoy.dollar.ui.styling.DollarColors

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
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = DollarColors.APP_BACKGROUND_COLOR,
        floatingActionButton = {
            if (currentRoute == "dashboard") {
                AddExpenseButton(navController)
            }
        },
        topBar = {
            if (currentRoute == "dashboard") {
                TopBar(
                    userName = "John Doe"
                )
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = "dashboard",
            modifier = Modifier.padding(it)
        ) {
            composable("dashboard") {
                DashboardView(viewState = MockDashboardData.mockDashboardState)
            }
            composable("add_expense") {
                AddExpenseView(
                    state = AddExpenseViewState(
                        expenseAmount = null,
                        expenseCategories = MockDashboardData.mockCategories,
                        expenseNote = ""
                    ),
                    navController = navController
                )
            }
        }
    }
}
