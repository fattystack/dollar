package com.fatchoy.dollar.feature.dashboard

import com.fatchoy.dollar.core.data.expenses.ExpensesViewState
import com.fatchoy.dollar.core.data.user.UserViewState

data class DashboardViewState(
    val user : UserViewState,
    val expenses : ExpensesViewState,
    val isLoading : Boolean = true,
    val error : String? = null,
) {
}