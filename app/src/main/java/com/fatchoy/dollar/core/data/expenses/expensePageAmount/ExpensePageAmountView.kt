package com.fatchoy.dollar.core.data.expenses.expensePageAmount

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.fatchoy.dollar.ui.styling.DollarColors
import com.fatchoy.dollar.ui.styling.DollarSize
import com.fatchoy.dollar.ui.theme.DollarTypography

@Composable
fun ExpensePageAmountView(
    state: ExpensePageAmountViewState,
    modifier: Modifier = Modifier
) {
    val amount = mutableStateOf(state.expenseAmount)

    Box(
        modifier = modifier.background(
            color = DollarColors.FORM_BACKGROUND,
            shape = RoundedCornerShape(DollarSize.CornerRadiusL),
        ),
        contentAlignment = Alignment.Center,

    ) {
        TextField(
            value = amount.value?.toString() ?: "",
            onValueChange = {
                    newValue ->
                if (newValue.isEmpty() || newValue.matches(Regex("^\\d*\\.?\\d*$"))) {
                    amount.value = newValue.toDoubleOrNull()
                }
            },
            modifier = modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "$0.00",
                    style = DollarTypography.H2_LIGHT.copy(
                        color = DollarColors.GRAY,
                        fontWeight = FontWeight.Bold
                    )
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(DollarSize.CornerRadiusL),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ExpensePageAmountViewPreview() {
    ExpensePageAmountView(
        state = ExpensePageAmountViewState()
    )
}
