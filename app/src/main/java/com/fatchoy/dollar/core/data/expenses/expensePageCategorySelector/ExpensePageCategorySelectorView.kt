package com.fatchoy.dollar.core.data.expenses.expensePageCategorySelector

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fatchoy.dollar.core.data.categoryChip.CategoryChipView
import com.fatchoy.dollar.ui.styling.DollarSpace

@Composable
fun ExpensePageCategorySelectorView(
    modifier: Modifier = Modifier,
    state: ExpensePageCategorySelectorViewState
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(DollarSpace.R),
        modifier = modifier.fillMaxWidth()
    ) {
        items(state.allCategories) { category ->
            CategoryChipView(
                state = category,
            )
        }
    }
}
