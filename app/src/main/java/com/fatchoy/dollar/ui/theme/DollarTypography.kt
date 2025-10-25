package com.fatchoy.dollar.ui.theme

import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.fatchoy.dollar.ui.styling.DollarColors

object DollarTypography {

    val H1 = TextStyle(
        fontSize = 56.sp,
        lineHeight = 1.30.em,
        fontWeight = FontWeight.Bold,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Proportional,
            trim = LineHeightStyle.Trim.Both
        ),
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    )

    val H2= TextStyle(
        fontSize = 28.sp,
        lineHeight = 1.25.em,
        fontWeight = FontWeight.Medium,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Proportional,
            trim = LineHeightStyle.Trim.Both
        ),
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    )
    val H2_LIGHT = TextStyle(
        fontSize = 28.sp,
        lineHeight = 1.25.em,
        fontWeight = FontWeight.Light,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Proportional,
            trim = LineHeightStyle.Trim.Both
        ),
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    )
    val Body = TextStyle(
        fontSize = 16.sp,
        lineHeight = 1.25.em,
        fontWeight = FontWeight.Light,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Proportional,
            trim = LineHeightStyle.Trim.Both
        ),
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    )
    val H4_LIGHT = TextStyle(
        fontSize = 16.sp,
        lineHeight = 1.25.em,
        fontWeight = FontWeight.Light,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Proportional,
            trim = LineHeightStyle.Trim.Both
        ),
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        color = DollarColors.GRAY
    )
}
