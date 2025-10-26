package com.fatchoy.dollar.feature.budgets.budgetCard

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.Clock
import java.time.LocalDate
import java.time.temporal.ChronoUnit

internal class BudgetCardChildViewModel(
    initialState: BudgetCardViewState,
    private val clock: Clock = Clock.systemDefaultZone()
) : ViewModel() {

    private val _state = MutableStateFlow(recomputeProgress(initialState))
    val state: StateFlow<BudgetCardViewState> = _state.asStateFlow()

    private val _events = MutableSharedFlow<BudgetCardEvent>(
        replay = 0,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    val events = _events.asSharedFlow()

    private fun recomputeProgress(s: BudgetCardViewState): BudgetCardViewState {
        val progress = computeProgress(s.budgetUsed, s.budgetAmount)
        return s.copy(budgetProgress = progress)
    }

    fun updateBudgetState(viewState: BudgetCardViewState) {
        _state.value = recomputeProgress(viewState)
    }

    fun updateUsedAmount(newUsed: Double) {
        val curr = _state.value.copy(budgetUsed = newUsed)
        _state.value = recomputeProgress(curr)
    }

    fun refresh() {
        _state.value = recomputeProgress(_state.value)
    }

    fun resetBudget() {
        val current = _state.value
        val newResetDate = current.budgetResetDate.plusMonths(1)
        _state.value = current.copy(
            budgetUsed = 0.0,
            budgetProgress = 0f,
            budgetResetDate = newResetDate
        )
    }

    override fun onCleared() {
        super.onCleared()
    }
}

private fun computeProgress(used: Double, amount: Double): Float {
    if (amount <= 0.0) return 0f
    return (used / amount).toFloat().coerceIn(0f, 1f)
}

/** Utility: days between today and reset date (not stored on state — UI can compute if it needs) */
internal fun computeRemainingDays(resetDate: LocalDate, clock: Clock = Clock.systemDefaultZone()): Long {
    val today = LocalDate.now(clock)
    return ChronoUnit.DAYS.between(today, resetDate)
}
