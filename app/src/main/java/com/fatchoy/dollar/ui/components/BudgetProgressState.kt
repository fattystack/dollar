package com.fatchoy.dollar.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class BudgetProgressState(
    val trackColor: Color = Color(0XFF9B9B9B),
    val icon: ImageVector = Icons.Default.Check,
    val iconScale: Float = 0.5f,
    val strokeWidth: Dp = 20.dp,
    val contentDescription: String? = null,
    val iconTint: Color = Color.Unspecified
)
