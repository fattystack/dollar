package com.fatchoy.dollar.feature.dashboard.expenseCard

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class ExpenseCardChildViewModel(
    initialState: ExpenseCardViewState
) : ViewModel() {

    private val _state = MutableStateFlow(recomputeExpenses(initialState))

    val state = StateFlow<ExpenseCardViewState>


    private fun recomputeExpenses(s: ExpenseCardViewState) {
        val
    }
}