package com.fatchoy.dollar.dummyAPI

import com.fatchoy.dollar.api.ExpenseApi
import kotlinx.coroutines.delay

class FakeExpenseApi(
    private val thisMonth: Double = 15250.80,
    private val previousMonth: Double = 15100.50,
    private val fail: Boolean = false,
    private val artificialDelayMs: Long = 500L
) : ExpenseApi {

    override suspend fun getThisMonthSpending(): Double {
        delay(artificialDelayMs)
        if (fail) throw RuntimeException("Simulated network error")
        return thisMonth
    }

    override suspend fun getPreviousMonthSpending(): Double {
        delay(artificialDelayMs)
        if (fail) throw RuntimeException("Simulated network error")
        return previousMonth
    }
}