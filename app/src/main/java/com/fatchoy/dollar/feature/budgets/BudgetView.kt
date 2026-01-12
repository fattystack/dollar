package com.fatchoy.dollar.feature.budgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fatchoy.dollar.core.data.budgetItem.BudgetItemView
import com.fatchoy.dollar.dummyAPI.MockBudgetData
import com.fatchoy.dollar.ui.styling.DollarPadding
import com.fatchoy.dollar.ui.styling.DollarSpace
import com.fatchoy.dollar.ui.theme.DollarTypography

@Composable
fun BudgetView(
    modifier: Modifier = Modifier,
    state: BudgetViewState
) {
    if (state.budgets.isEmpty()) {
        EmptyBudgetView(modifier)
    } else {
        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = DollarPadding.L),
            verticalArrangement = Arrangement.spacedBy(DollarSpace.R)
        ) {
            item {
                Text(
                    text = "Your Budgets",
                    style = DollarTypography.H1,
                    modifier = Modifier
                        .padding(horizontal = DollarPadding.L)
                )
            }
            items(state.budgets) { budgetItem ->
                BudgetItemView(
                    modifier = Modifier
                        .padding(horizontal = DollarPadding.L),
                    state = budgetItem
                )
            }
        }
    }
}

@Composable
fun EmptyBudgetView(modifier: Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // text might change
        Text(
            text = "No budgets available. Please add a budget.",
            style = DollarTypography.H2
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BudgetsViewPreview() {
    BudgetView(
        state = BudgetViewState(
            budgets = MockBudgetData.mockBudgets
        )
    )
}

@Preview(showBackground = true)
@Composable
fun EmptyBudgetsViewPreview() {
    BudgetView(
        state = BudgetViewState(
            budgets = emptyList()
        )
    )
}
