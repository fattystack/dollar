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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fatchoy.dollar.ui.styling.DollarColors
import com.fatchoy.dollar.ui.styling.DollarScale
import com.fatchoy.dollar.ui.styling.DollarWidth

@Composable
internal fun BudgetProgressBarModelMaker(
    progress: Float,
    icon: ImageVector = Icons.Default.Check,
    iconTint: Color = Color.Unspecified,
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

        val innerDiameter: Dp = (parentSize - DollarWidth.S * 2 * DollarScale.FULL).coerceAtLeast(0.dp)
        val iconSize: Dp = (innerDiameter * DollarScale.HALF).coerceAtLeast(0.dp)

        CircularProgressIndicator(
            progress = { p },
            color = ringColor,
            strokeWidth = DollarWidth.S,
            modifier = Modifier.fillMaxSize(),
            trackColor = DollarColors.GRAY,
        )

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = if (iconTint == Color.Unspecified) ringColor else iconTint,
            modifier = Modifier.size(iconSize)
        )
    }
}

@Preview
@Composable
internal fun BudgetProgressBarModelMakerPreview() {
    BudgetProgressBarModelMaker(
        progress = 0.9f
    )
}