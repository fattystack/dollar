package com.fatchoy.dollar.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.fatchoy.dollar.ui.styling.DollarColors

@Composable
fun Navbar(
    navigationController: NavController,
    currentRoute: String?,
) {
    NavigationBar(
        containerColor = DollarColors.APP_BACKGROUND_COLOR
    ) {
        val items = listOf(
            BottomNavItem.Dashboard,
            BottomNavItem.Budgets,
            BottomNavItem.Transactions,
            BottomNavItem.Profile
        )

        items.forEach { path ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = path.icon,
                        contentDescription = path.title
                    )
                },
                label = { Text(path.title) },
                selected = currentRoute == path.route,
                onClick = {
                    navigationController.navigate(path.route) {
                        popUpTo(navigationController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = DollarColors.GREEN,
                    unselectedIconColor = DollarColors.DARK_GRAY,
                    selectedTextColor = DollarColors.GREEN,
                    unselectedTextColor = DollarColors.DARK_GRAY,
                    indicatorColor = Color.Transparent

                )

            )
        }
    }
}
