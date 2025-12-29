package com.fatchoy.dollar.feature.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fatchoy.dollar.core.data.categoryChip.CategoryChipView
import com.fatchoy.dollar.core.data.categoryChip.CategoryChipViewState
import com.fatchoy.dollar.core.data.expenseItemCard.ExpenseItemCardView
import com.fatchoy.dollar.core.data.expenseItemCard.ExpenseItemCardViewState
import com.fatchoy.dollar.core.data.expenseSummaryCard.ExpenseSummaryCardView
import com.fatchoy.dollar.core.data.monthlySpentCard.MonthlySpentCardView
import com.fatchoy.dollar.ui.styling.DollarSpace
import com.fatchoy.dollar.ui.theme.DollarTypography

@Composable
fun DashboardView(
    viewState: DashboardViewState,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(DollarSpace.L)
    ) {
        item {
            ExpenseSummaryCardView(
                state = viewState.expenseSummaryCardState,
                modifier = modifier
            )
        }
        item {
            MonthlySpentCardView(
                state = viewState.monthlySpentCardViewState,
                modifier = modifier
            )
        }
        item {
            GetCategories(
                categories = viewState.frequentCategories
            )
        }
        item {
            GetRecentTransactions(
                recentExpenses = viewState.recentExpenses
            )
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

@Composable
fun GetCategories(modifier: Modifier = Modifier, categories: List<CategoryChipViewState>) {
    Column(
        modifier = modifier.padding(start = DollarSpace.R),
        verticalArrangement = Arrangement.spacedBy(DollarSpace.S)
    ) {
        GetSectionTitle("Top Categories")
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(DollarSpace.R)
        ) {
            items(categories.size) { idx ->
                val category = categories[idx]
                CategoryChipView(
                    state = category
                )
            }
        }
    }
}

@Composable
fun GetRecentTransactions(modifier: Modifier = Modifier, recentExpenses: List<ExpenseItemCardViewState>) {
    Column(
        modifier = modifier.padding(horizontal = DollarSpace.R),
        verticalArrangement = Arrangement.spacedBy(DollarSpace.R)
    ) {
        GetSectionTitle("Recent Transactions")
        recentExpenses.forEach { expense ->
            ExpenseItemCardView(
                state = expense
            )
        }
    }
}
