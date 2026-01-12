package com.fatchoy.dollar.core.data.budgetItem

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fatchoy.dollar.core.data.expenses.expenseItemCard.ExpenseItemCardView
import com.fatchoy.dollar.core.data.expenses.expenseItemCard.ExpenseItemCardViewState
import com.fatchoy.dollar.ui.styling.DollarColors
import com.fatchoy.dollar.ui.styling.DollarPadding
import com.fatchoy.dollar.ui.styling.DollarSize
import com.fatchoy.dollar.ui.styling.DollarSpace
import com.fatchoy.dollar.ui.theme.DollarTypography

// TODO Fix Styling to match design
@Composable
fun BudgetItemView(
    modifier: Modifier = Modifier,
    state: BudgetItemViewState
) {
    var isExpanded by remember { mutableStateOf(state.isExpanded) }

    Column(modifier = modifier) {
        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.White
            )
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { isExpanded = !isExpanded }
                        .padding(DollarPadding.R)
                ) {
                    BudgetItemHeader(state = state, isExpanded = isExpanded)
                    Spacer(modifier = Modifier.height(DollarSpace.R))
                    BudgetProgressSection(state = state)
                }
                AnimatedVisibility(visible = isExpanded) {
                    BudgetTransactionsList(transactions = state.transactions)
                }
            }
        }
    }
}

@Composable
private fun BudgetItemHeader(
    state: BudgetItemViewState,
    isExpanded: Boolean
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(DollarSpace.R),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CategoryIconBox(
                icon = state.categoryIcon,
                backgroundColor = state.categoryIconBackground
            )

            Column {
                Text(
                    text = state.categoryName,
                    style = DollarTypography.Body.copy(color = Color.Black)
                )
                Text(
                    text = state.totalSpentFormatted,
                    style = DollarTypography.Body.copy(color = Color.Gray)
                )
            }
        }

        Icon(
            imageVector = if (isExpanded) {
                Icons.Default.KeyboardArrowUp
            } else {
                Icons.Default.KeyboardArrowDown
            },
            contentDescription = if (isExpanded) "Collapse" else "Expand",
            tint = Color.Gray
        )
    }
}

@Composable
private fun CategoryIconBox(
    icon: Int,
    backgroundColor: Color
) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(backgroundColor.copy(alpha = 0.15f)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = backgroundColor,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
private fun BudgetProgressSection(state: BudgetItemViewState) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(DollarSize.CornerRadiusXS))
                .background(DollarColors.GRAY.copy(alpha = 0.3f))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(state.progress.coerceIn(0f, 1f))
                    .fillMaxHeight()
                    .background(
                        if (state.progress > 1f) {
                            DollarColors.RED
                        } else {
                            DollarColors.GREEN
                        }
                    )
            )
        }

        Spacer(modifier = Modifier.height(DollarSpace.XS))

        Text(
            text = "${state.totalSpentFormatted} of ${state.budgetLimitFormatted}",
            style = DollarTypography.Body.copy(color = Color.Gray)
        )
    }
}

@Composable
private fun BudgetTransactionsList(
    transactions: List<ExpenseItemCardViewState>
) {
    Column(modifier = Modifier.padding(top = DollarSpace.S)) {
        transactions.forEach { transaction ->
            ExpenseItemCardView(state = transaction)
        }
    }
}
