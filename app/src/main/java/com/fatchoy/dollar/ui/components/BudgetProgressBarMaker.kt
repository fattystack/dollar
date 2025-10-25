package com.fatchoy.dollar.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.min

@Composable
internal fun BudgetProgressBarModelMaker(
    progress: Float,
    viewState: BudgetProgressState = BudgetProgressState()
) {
    val p by animateFloatAsState(progress.coerceIn(0f, 1f), label = "ring")

    val ringColor = when {
        progress >= 0.9f -> DollarColors.PROGRESS_RED
        progress >= 0.7f ->  DollarColors.PROGRESS_YELLOW
        else -> DollarColors.PROGRESS_GREEN

    }

    BoxWithConstraints(
        modifier = Modifier.aspectRatio(DollarScale.FULL),
        contentAlignment = Alignment.Center
    ) {
        val parentSize: Dp = minOf(maxWidth, maxHeight)

        val innerDiameter: Dp = (parentSize - viewState.strokeWidth * 2f).coerceAtLeast(0.dp)
        val iconSize: Dp = (innerDiameter * viewState.iconScale).coerceAtLeast(0.dp)

        CircularProgressIndicator(
            progress = { p },
            color = ringColor,
            strokeWidth = viewState.strokeWidth,
            modifier = Modifier.fillMaxSize(),
            trackColor = viewState.trackColor
        )

        Icon(
            imageVector = viewState.icon,
            contentDescription = viewState.contentDescription,
            tint = if (viewState.iconTint == Color.Unspecified) ringColor else viewState.iconTint,
            modifier = Modifier.size(iconSize)
        )
    }
}

@Preview
@Composable
internal fun BudgetProgressBarModelMakerPreview() {
    BudgetProgressBarModelMaker(
        progress = 0.3f,
        viewState = BudgetProgressState(icon = Icons.Default.Check)
    )
}
