package com.fatchoy.dollar.ui.styling

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object ExpenseCardTokens {
    val Corner = 16.dp
    val Padding = 20.dp
    val GapSmall = 8.dp
    val Elevation = 3.dp
    val IconSize = 18.dp
}

object Semantic {
    val Green = Color(0xFF3BAA6C) // subtle green
    val Red = Color(0xFFD95C5C) // subtle red (not neon)
    val Neutral = Color(0xFF6B7280) // gray
    val Gray = Color(0xFF6B7280)

    val TextHeader = Color(0xFF1F1F1F)
    val TextSubheader = Color(0xFF666666)

    val ExpenseCardBackground = Color(0xFFFFFFFF)
}

@Composable
fun trendColor(direction: Int): Color = when (direction) {
    1 -> Semantic.Green // up
    2 -> Semantic.Red // down
    else -> Semantic.Neutral // neutral
}
