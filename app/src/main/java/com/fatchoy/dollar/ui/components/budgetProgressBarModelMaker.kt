package com.fatchoy.dollar.ui.components

import android.graphics.drawable.Icon
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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

@Composable
internal fun BudgetProgressBarModelMaker (
    modifier: Modifier = Modifier.size(48.dp),
    progress: Float,
    trackColor: Color = Color(0XFF9B9B9B),
    icon: ImageVector = Icons.Default.Check,
    iconScale: Float = 0.5f,
    strokeWidth: Dp = 20.dp,
    contentDescription: String? = null
) {

    val p by animateFloatAsState(progress.coerceIn(0f,1f), label = "ring")
    val percentColor = if (progress >= 0.9) Color(0XFFD95C5C) else if (progress >= 0.7) Color(0XFFE8A200) else Color(0XFF9CAF88)
    //track
   Box(
        modifier = Modifier.aspectRatio(1f),
       contentAlignment = Alignment.Center
   ) {
       CircularProgressIndicator(
           progress = progress,
           color = percentColor,
           strokeWidth = strokeWidth,
           modifier = Modifier.fillMaxSize(),
           trackColor = trackColor,
       )
       Icon (
           imageVector = icon,
           contentDescription = contentDescription,
           modifier = Modifier.size((modifier as? Modifier)?.let {
               24.dp
           } ?: (48.dp * iconScale))
       )

   }


}

@Preview
@Composable
internal fun BudgetProgressBarModelMakerPreview() {
    BudgetProgressBarModelMaker(
        progress = 0.3f
    )
}