package com.example.ecommerce_jetpack_compose.ui.components

import android.R.attr.rating
import android.media.Rating
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerce_jetpack_compose.data.entity.Urunler

@Composable
fun CustomUrunHeaderSection(urun: Urunler, deger: Float, onRatingChanged: (Float) -> Unit) {
    Column(modifier = Modifier.padding(32.dp)) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = urun.marka)
            Spacer(modifier = Modifier.width(98.dp))
            StarRatingBar(
                maxStars = 5,
                rating = deger,
                onRatingChanged = {
                        yeniDeger ->
                    onRatingChanged(yeniDeger)

                }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier,
            fontSize = 24.sp,
            text = urun.ad,
            fontWeight = FontWeight.Bold
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            thickness = 1.dp,
            color = Color.LightGray
        )
    }
}