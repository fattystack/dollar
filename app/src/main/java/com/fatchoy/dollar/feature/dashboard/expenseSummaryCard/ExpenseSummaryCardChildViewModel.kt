package com.fatchoy.dollar.feature.dashboard.expenseSummaryCard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fatchoy.dollar.dummyAPI.FakeExpenseApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

internal class ExpenseSummaryCardChildViewModel(
    initialState: ExpenseSummaryCardViewState,
    private val api: FakeExpenseApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {

    private val _state = MutableStateFlow(initialState)

    val state: StateFlow<ExpenseSummaryCardViewState> = _state.asStateFlow()

    fun refresh() {
        fetchData()
    }

    fun retry() {
        fetchData()
    }

    fun updateMoneySpent(newAmount: Double) {
        _state.value = _state.value.copy(moneySpent = newAmount, error = null)
    }

    fun setLoading(isLoading: Boolean) {
        _state.value = _state.value.copy(isLoading = isLoading, error = null)
    }

    fun setError(message: String?) {
        _state.value = _state.value.copy(error = message)
    }

    private fun fetchData() {
        if (_state.value.isLoading) return

        _state.value = _state.value.copy(isLoading = true, error = null)

        viewModelScope.launch(ioDispatcher) {
            try {
                val current = api.getThisMonthSpending()
                val previous = api.getPreviousMonthSpending()

                val comparison = computeComparison(current, previous)
                val direction = computeDirection(comparison)

                _state.value = _state.value.copy(
                    moneySpent = current,
                    comparisonAmount = comparison,
                    comparisonDirection = direction,
                    isLoading = false,
                    error = null
                )
            } catch (e: IOException) {
                println("ExpenseCard fetch IO error: ${e.message}")
                _state.value = _state.value.copy(isLoading = false, error = e.message ?: "Network error")
            }
        }
    }

    private fun computeComparison(current: Double, previous: Double): Double {
        return current - previous
    }

    private fun computeDirection(comparison: Double): Int {
        return when {
            comparison > 0.0 -> 2
            comparison < 0.0 -> 1
            else -> 0
        }
    }
}
