package com.fatchoy.dollar.api

interface ExpenseApi {
    suspend fun getThisMonthSpending(): Double
    suspend fun getPreviousMonthSpending(): Double
}