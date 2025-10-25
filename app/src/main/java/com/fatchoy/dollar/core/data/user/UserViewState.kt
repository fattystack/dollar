package com.fatchoy.dollar.core.data.user

import com.fatchoy.dollar.core.ui.user.UserUI

sealed interface UserViewState {
    data object Loading : UserViewState
    data object Guest : UserViewState
    data class Authenticated(val user: UserUI) : UserViewState
    data class Error(val message: String) : UserViewState
}
