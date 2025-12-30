package com.fatchoy.dollar.core.data.expenses.expensePageNotes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.fatchoy.dollar.ui.styling.DollarColors
import com.fatchoy.dollar.ui.styling.DollarSize
import com.fatchoy.dollar.ui.theme.DollarTypography

@Composable
fun ExpensePageNotesView(
    modifier: Modifier = Modifier,
    state: ExpensePageNotesViewState
) {
    val notes = mutableStateOf(state.expenseNotes)
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = DollarColors.FORM_BACKGROUND,
                shape = RoundedCornerShape(DollarSize.CornerRadiusL)
            )
    ) {
        TextField(
            value = notes.value ?: "",
            onValueChange = { newValue ->
                notes.value = newValue
            },
            modifier = modifier
                .fillMaxWidth()
                .height(DollarSize.NOTE_HEIGHT),

            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    text = "Enter a note",
                    style = DollarTypography.H4_LIGHT
                )
            },
            shape = RoundedCornerShape(DollarSize.CornerRadiusL),
            maxLines = 5
        )
    }
}
