package com.example.smartinezfinanceapp.models

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

data class User(
    val name: String,
    val currentBalance: Double
)

data class SummaryCard(
    val title: String,
    val amount: Double,
    val backgroundColor: Color
)

data class Transaction(
    val establishment: String,
    val category: String,
    val amount: Double,
    val time: String,
    val icon: ImageVector
)

val mockUser = User(
    name = "Juan",
    currentBalance = 5430.00
)

val mockSummaryCards = listOf(
    SummaryCard("Actividad\nde la Semana", 1200.50, Color(0xFF00C853)),
    SummaryCard("Ventas\ntotales", 280.99, Color(0xFF1E1E1E)),
    SummaryCard("Ganancias\ntotales", 280.99, Color(0xFF1B5E20))
)

val mockTransactions = listOf(
    Transaction("Supermarket", "Groceries", -45.99, "10:30 AM", Icons.Default.ShoppingCart),
    Transaction("Gas Station", "Fuel", -30.50, "12:15 PM", Icons.Default.LocalGasStation),
    Transaction("Coffee Shop", "Food & Drinks", -5.75, "8:00 AM", Icons.Default.LocalCafe),
    Transaction("Electronics Store", "Electronics", -120.00, "3:45 PM", Icons.Default.Computer),
    Transaction("Bookstore", "Books", -25.99, "2:00 PM", Icons.Default.MenuBook),
    Transaction("Restaurant", "Dining", -60.00, "7:30 PM", Icons.Default.Restaurant)
)