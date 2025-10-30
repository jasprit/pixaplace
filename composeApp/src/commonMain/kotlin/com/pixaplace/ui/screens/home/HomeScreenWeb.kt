package com.pixaplace.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pixaplace.ui.components.AppTextField
import com.pixaplace.ui.components.CompactDealCard
import com.pixaplace.ui.components.FeaturedDealBanner
import com.pixaplace.ui.components.PrimaryButton
import data.model.Deal
import data.model.categories

// Sample data classes
@Composable
fun DealsHomeWeb(
    state: DealsUiState,
    onDealClick: (Deal) -> Unit,
    onMoreClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
        //   .verticalScroll(rememberScrollState())
    ) {
        // Header
        Text(
            "Deals & Coupons",
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            "Handpicked offers across categories",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(24.dp))

        // Search + Categories
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            AppTextField(
                value = state.searchQuery,
                onValueChange = { },
                label = "Search deals, brands, or categories...",
                modifier = Modifier.weight(1f).padding(end = 16.dp)
            )
        }

        Spacer(Modifier.height(24.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(categories) { cat ->
                FilterChip(
                    selected = state.selectedCategory == cat,
                    onClick = { },
                    label = { Text(cat) })
            }
        }

        Spacer(Modifier.height(32.dp))

        // Featured Banner
        state.featuredDeal?.let {
            FeaturedDealBanner(it, onClick = { onDealClick(it) })
            Spacer(Modifier.height(32.dp))
        }

        // Deals Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(state.deals) { deal ->
                CompactDealCard(deal, onClick = { onDealClick(deal) })
            }
        }

        Spacer(Modifier.height(32.dp))
        PrimaryButton(
            text = "Load More",
            onClick = onMoreClick,
            modifier = Modifier.align(Alignment.CenterHorizontally).width(300.dp)
        )
    }
}