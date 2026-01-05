package com.fatchoy.dollar.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Receipt
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Dashboard : BottomNavItem(
        route = "dashboard",
        title = "Dashboard",
        icon = Icons.Outlined.Home
    )

    object Budgets : BottomNavItem(
        route = "budgets",
        title = "Budgets",
        icon = Icons.Default.Wallet
    )

    object Transactions : BottomNavItem(
        route = "transactions",
        title = "Transactions",
        icon = Icons.Outlined.Receipt
    )

    object Profile : BottomNavItem(
        route = "profile",
        title = "Profile",
        icon = Icons.Outlined.Person
    )

    companion object {
        val items = listOf(Dashboard, Budgets, Transactions, Profile)
        val routes = items.map { it.route }
    }
}
