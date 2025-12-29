package com.fatchoy.dollar.ui.styling

import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

internal object DollarColors {
    val GRAY: Color = Color(0XFF9B9B9B)
    val BLACK: Color = Color(0xFF000000)
    val PROGRESS_RED: Color = Color(0xFFE57373)
    val PROGRESS_YELLOW: Color = Color(0xFFFFB74D)
    val PROGRESS_GREEN: Color = Color(0xFF81C784)

    val MONTHLY_RED: Color = Color(0xFFD84545)

    val MONTHLY_GREEN: Color = Color(0xFF2E7D6E)

    val CATEGORY_COLOR: Color = Color(0xFF2E7D6E)

    // Mock data colors
    val MOCK_EXPENSE_RED: Color = Color(0xFFE57373)
    val MOCK_EXPENSE_BLUE: Color = Color(0xFF64B5F6)
    val MOCK_EXPENSE_GREEN: Color = Color(0xFF81C784)

    val APP_BACKGROUND_COLOR: Color = Color(0xFFF9F9F9)

    val WHITE: Color = Color(0xFFFFFFFF)
}

@Composable
fun defaultCardColors() = CardDefaults.cardColors(
    containerColor = DollarColors.WHITE,
    contentColor = MaterialTheme.colorScheme.onSurface
)
