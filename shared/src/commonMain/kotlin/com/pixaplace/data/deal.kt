package data.model


data class Deal(
    val id: String,
    val title: String,
    val description: String,
    val discount: String,
    val category: String,
    val expiresAt: String, // e.g., "Oct 31"
    val isFeatured: Boolean = false,
    val badge: Badge? = null
)

data class Badge(
    val text: String,
    val color: String
)

// Sample Data
val sampleDeals = listOf(
    Deal(
        id = "1",
        title = "50% Off iPhone 15",
        description = "Use code PHONE50 at checkout",
        discount = "50%",
        category = "Phone",
        expiresAt = "Oct 31",
        isFeatured = true,
        badge = Badge("HOT", "error") // Use Material3 semantic color
    ),
    Deal("2", "Spotify Premium", "3 months free trial", "FREE", "Music", "Nov 15"),
    Deal("3", "NYC Flights", "Book by Dec 31", "30%", "Flights", "Dec 31"),
    Deal("4", "Burger Combo", "Buy 1 Get 1 Free", "B1G1", "Food", "Today"),
    Deal("5", "Laptop Sale", "Up to 40% off", "40%", "Electronics", "Nov 10"),
    Deal("6", "Air Tickets", "Limited seats", "25%", "Flights", "Oct 28")
)

val categories = listOf("All", "Phone", "Music", "Flights", "Food", "Electronics")