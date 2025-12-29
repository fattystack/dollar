package com.fatchoy.dollar.ui.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.fatchoy.dollar.ui.styling.DollarColors

@Composable
fun AddExpenseButton(
    navController: NavController
) {
    FloatingActionButton(
        onClick = { navController.navigate("add_expense") },
        containerColor = DollarColors.GREEN,
        contentColor = Color.White,
        shape = CircleShape
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add Expense"
        )
    }
}