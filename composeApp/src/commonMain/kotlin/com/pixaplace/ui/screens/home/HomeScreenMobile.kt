import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.pixaplace.theme.WhiteLabelTheme
import com.pixaplace.ui.components.AppTextField
import com.pixaplace.ui.components.CompactDealCard
import com.pixaplace.ui.components.PrimaryButton
import data.model.categories
import data.model.sampleDeals


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenMobile(onMoreClicked: () -> Unit) {
    WhiteLabelTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Deals & Coupons") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                //    .verticalScroll(rememberScrollState())
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Search Bar
                AppTextField(
                    value = "",
                    onValueChange = { /* Search logic */ },
                    label = "Search deals, brands, or categories...",
                    keyboardType = KeyboardType.Text
                )

                // Categories (Horizontal Chips)
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(categories) { category ->
                        FilterChip(
                            selected = false,
                            onClick = { /* Filter */ },
                            label = { Text(category) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.secondary
                            )
                        )
                    }
                }

                // Deals List (Vertical)
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(sampleDeals) { deal ->
                        CompactDealCard(deal, onClick = {})
                    }
                }

                // CTA
                PrimaryButton(
                    text = "Load More Deals",
                    onClick = onMoreClicked,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}