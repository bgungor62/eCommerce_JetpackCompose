package com.example.ecommerce_jetpack_compose.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.ecommerce_jetpack_compose.R

@Composable
fun CustomKategoriItem(kategori: String, icon: ImageVector, onClick: () -> Unit) {
    Spacer(modifier = Modifier.width(8.dp))
    Card(
        modifier = Modifier,
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        onClick = onClick
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Icon(
                icon,
                contentDescription = "Delete Icon",
                tint = colorResource(id = R.color.acik_mavi)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = kategori)

        }
    }
}