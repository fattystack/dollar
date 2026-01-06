package com.fatchoy.dollar.feature.transactions

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fatchoy.dollar.core.data.expenses.expenseItemCard.ExpenseItemCardView
import com.fatchoy.dollar.dummyAPI.MockDashboardData
import com.fatchoy.dollar.ui.styling.DollarSpace
import com.fatchoy.dollar.ui.theme.DollarTypography

@Composable
fun TransactionsView(
    modifier: Modifier = Modifier,
    state: TransactionsViewState
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
            .padding(horizontal = DollarSpace.R)
    ) {
        state.transactions.forEach { (date, trans) ->
            item {
                Text(
                    text = date,
                    style = DollarTypography.SECTION_HEADER,
                    modifier = Modifier.padding(
                        vertical = DollarSpace.R
                    )
                )
            }

            items(trans) { t ->
                ExpenseItemCardView(state = t)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TransactionsViewPreview() {
    TransactionsView(
        state = TransactionsViewState(
            transactions = MockDashboardData.mockGroupedTransactions
        )
    )
}
