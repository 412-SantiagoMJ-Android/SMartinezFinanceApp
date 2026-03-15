package com.example.smartinezfinanceapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.smartinezfinanceapp.models.mockUser
import com.example.smartinezfinanceapp.ui.theme.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.example.smartinezfinanceapp.models.mockSummaryCards

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BlackBackground)
            .padding(16.dp)
    ) {
        HeaderSection()

        Spacer(modifier = Modifier.height(32.dp))

        SummaryCardsSection()

        Spacer(modifier = Modifier.height(32.dp))

        // (Aquí irán las transacciones más adelante)
    }
}

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(DarkCard),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Perfil",
                    tint = TextWhite,
                    modifier = Modifier.size(30.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = "Hola ${mockUser.name}",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextWhite
                )
                Text(
                    text = "Bienvenido",
                    fontSize = 14.sp,
                    color = TextGray
                )
            }
        }

        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Menú",
            tint = TextWhite,
            modifier = Modifier.size(28.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Composable
fun SummaryCardsSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SummaryCardItem(
            card = mockSummaryCards[0],
            modifier = Modifier
                .weight(1f)
                .height(216.dp)
        )
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            SummaryCardItem(
                card = mockSummaryCards[1],
                modifier = Modifier.height(100.dp).fillMaxWidth()
            )

            SummaryCardItem(
                card = mockSummaryCards[2],
                modifier = Modifier.height(100.dp).fillMaxWidth()
            )
        }
    }
}

@Composable
fun SummaryCardItem(card: com.example.smartinezfinanceapp.models.SummaryCard, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = card.backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = card.title,
                color = if (card.backgroundColor == Color(0xFF00C853)) Color.Black else TextWhite, // Letra negra para el verde brillante, blanca para oscuros
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                lineHeight = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$${card.amount}",
                color = if (card.backgroundColor == Color(0xFF00C853)) Color.Black else TextWhite,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}