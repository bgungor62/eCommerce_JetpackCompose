package com.example.ecommerce_jetpack_compose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Composable
fun UcTabliArayuz() {
    var seciliTabIndex by remember { mutableStateOf(0) }
    val tabBasliklari = listOf("Ürünler", "Kategoriler", "Sepet")

    Column {
        TabRow(
            selectedTabIndex = seciliTabIndex,
            containerColor = Color.White,
            contentColor = Color.Blue
        ) {
            tabBasliklari.forEachIndexed { index, baslik ->
                Tab(
                    selected = seciliTabIndex == index,
                    onClick = { seciliTabIndex = index },
                    text = { Text(baslik) }
                )
            }
        }

        when (seciliTabIndex) {
            0 -> Text("Ürünler içeriği")
            1 -> Text("Kategoriler içeriği")
            2 -> Text("Sepet içeriği")
        }
    }
}