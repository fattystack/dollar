package com.fatchoy.dollar.feature.addExpense

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fatchoy.dollar.core.data.expenses.expensePageAmount.ExpensePageAmountView
import com.fatchoy.dollar.core.data.expenses.expensePageAmount.ExpensePageAmountViewState
import com.fatchoy.dollar.core.data.expenses.expensePageCategorySelector.ExpensePageCategorySelectorView
import com.fatchoy.dollar.core.data.expenses.expensePageCategorySelector.ExpensePageCategorySelectorViewState
import com.fatchoy.dollar.core.data.expenses.expensePageNotes.ExpensePageNotesView
import com.fatchoy.dollar.core.data.expenses.expensePageNotes.ExpensePageNotesViewState
import com.fatchoy.dollar.dummyAPI.MockDashboardData.mockCategories
import com.fatchoy.dollar.ui.styling.DollarColors
import com.fatchoy.dollar.ui.styling.DollarPadding
import com.fatchoy.dollar.ui.styling.DollarSize
import com.fatchoy.dollar.ui.styling.DollarSpace
import com.fatchoy.dollar.ui.theme.DollarTypography

@Composable
fun AddExpenseView(
    modifier: Modifier = Modifier,
    navController: NavController,
    state: AddExpenseViewState
) {
    Scaffold(
        topBar = {
            ExpenseTopBar(navController)
        },
        containerColor = DollarColors.APP_BACKGROUND_COLOR
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(DollarColors.APP_BACKGROUND_COLOR)
                .padding(DollarPadding.S),
            verticalArrangement = Arrangement.spacedBy(DollarSpace.XL),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(DollarSpace.R)
            ) {
                GetSectionTitle(headerString = "Amount")
                ExpensePageAmountView(
                    state = ExpensePageAmountViewState(expenseAmount = state.expenseAmount)
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(DollarSpace.R)
            ) {
                GetSectionTitle(headerString = "Category")
                ExpensePageCategorySelectorView(
                    state = ExpensePageCategorySelectorViewState(allCategories = state.expenseCategories)
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(DollarSpace.R)
            ) {
                GetSectionTitle(headerString = "Notes")
                ExpensePageNotesView(state = ExpensePageNotesViewState(expenseNotes = state.expenseNote))
            }

            Button(
                onClick = { navController.navigateUp() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(DollarSize.EXPENSE_BUTTON_SIZE),
                colors = ButtonDefaults.buttonColors(
                    containerColor = DollarColors.GREEN
                ),
                shape = RoundedCornerShape(DollarSize.CornerRadiusL)
            ) {
                Text(
                    text = "Save",
                    style = DollarTypography.SECTION_HEADER.copy(
                        color = Color.White
                    )
                )
            }
        }
    }
}

@Composable
fun GetSectionTitle(headerString: String) {
    Text(
        text = headerString,
        style = DollarTypography.SECTION_HEADER,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpenseTopBar(navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = "Add Expense",
                style = DollarTypography.SECTION_HEADER
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = DollarColors.APP_BACKGROUND_COLOR
        )
    )
}

@Preview(showBackground = true)
@Composable
fun AddExpenseViewPreview() {
    AddExpenseView(
        state = AddExpenseViewState(
            expenseAmount = null,
            expenseCategories = mockCategories,
            expenseNote = "",
        ),
        navController = rememberNavController()
    )
}
