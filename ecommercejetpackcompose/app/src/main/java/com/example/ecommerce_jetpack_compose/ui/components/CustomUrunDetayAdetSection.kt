package com.example.ecommerce_jetpack_compose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomUrunDetayAdetSection(adet: Int, adetAzalt: () -> Unit, adetArttir: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(modifier = Modifier, onClick = adetAzalt) { Text(text = "-", fontSize = 20.sp) }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "${adet}", fontWeight = FontWeight.Bold, fontSize = 32.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Button(modifier = Modifier, onClick =adetArttir) { Text(text = "+", fontSize = 20.sp) }

    }
}