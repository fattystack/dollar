package com.fatchoy.dollar.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
internal fun budgetProgressBarModelMaker (
    viewState: BudgetProgressBarModelState,
    trackColor: Color = Color(0XFFE5E6E8),
    ringSize: Dp = 80.dp,
    strokeWidth: Dp = 10.dp,
) {

    val p by animateFloatAsState(viewState.progress.coerceIn(0f,1f), label = "ring")
    val percentColor = if (viewState.percentage >= 90) Color(0XFFD95C5C) else if (viewState.percentage >= 70) Color(0XFFE8A200) else Color(0XFF9CAF88)
    //track
    CircularProgressIndicator(
        progress = viewState.progress,
        color = percentColor,
        strokeWidth = strokeWidth,
        modifier = Modifier.fillMaxSize(),
        trackColor = trackColor,
    )

}