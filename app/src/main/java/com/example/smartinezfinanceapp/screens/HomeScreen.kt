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

// Importamos los datos y colores que creamos antes
import com.example.smartinezfinanceapp.models.mockUser
import com.example.smartinezfinanceapp.ui.theme.*

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    // Contenedor principal de toda la pantalla
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BlackBackground) // Nuestro fondo oscuro de finanzas
            .padding(16.dp)
    ) {
        // 1. El Encabezado
        HeaderSection()

        Spacer(modifier = Modifier.height(32.dp))

        // (Aquí irán las tarjetas resumen en el siguiente paso)

        Spacer(modifier = Modifier.height(32.dp))

        // (Aquí irán las transacciones más adelante)
    }
}

@Composable
fun HeaderSection() {
    // Row para poner el perfil a la izquierda y el menú a la derecha
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween, // Separa los elementos a los extremos
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Row interno para el icono y los textos de saludo
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Círculo del perfil
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(DarkCard), // Fondo gris oscuro para el icono
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

            // Textos de saludo
            Column {
                Text(
                    text = "Hola ${mockUser.name}",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextWhite // Texto blanco para que resalte en fondo negro
                )
                Text(
                    text = "Bienvenido",
                    fontSize = 14.sp,
                    color = TextGray // Gris para el subtítulo
                )
            }
        }

        // Icono de Menú Hamburguesa a la derecha
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Menú",
            tint = TextWhite,
            modifier = Modifier.size(28.dp)
        )
    }
}

// Vista previa para que vayas viendo cómo queda
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}