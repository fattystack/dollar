package com.fatchoy.dollar.feature.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fatchoy.dollar.core.data.expenseSummaryCard.ExpenseSummaryCardView

@Composable
fun DashboardView(
    viewState: DashboardViewState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        ExpenseSummaryCardView(
            state = viewState.expenseSummaryCardState,
            modifier = modifier
        )
    }
}
