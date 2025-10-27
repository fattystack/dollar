package com.fatchoy.dollar.dummyAPI

import com.fatchoy.dollar.api.ExpenseApi
import kotlinx.coroutines.delay
import java.io.IOException

class FakeExpenseApi(
    private val thisMonth: Double = 15250.80,
    private val previousMonth: Double = 15100.50,
    private val fail: Boolean = false,
    private val artificialDelayMs: Long = 500L
) : ExpenseApi {

    override suspend fun getThisMonthSpending(): Double {
        if (artificialDelayMs > 0) delay(artificialDelayMs)
        if (fail) throw IOException("Simulated fetch error (this month)") as Throwable
        return thisMonth
    }

    override suspend fun getPreviousMonthSpending(): Double {
        if (artificialDelayMs > 0) delay(artificialDelayMs)
        if (fail) throw IOException("Simulated fetch error (previous month)") as Throwable
        return previousMonth
    }
}
