package com.example.ecommerce_jetpack_compose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerce_jetpack_compose.R
import com.example.ecommerce_jetpack_compose.data.entity.Urunler

@Composable
fun CustomUrunDetayBottom(urun: Urunler, onClick: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxHeight()
    ) {
        Text(
            text = "Fiyat",
            fontSize = 12.sp,
            color = Color.Gray
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = "₺${urun.fiyat}",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp),
                onClick = onClick,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.button_renk),
                    contentColor = colorResource(R.color.white)
                )
            ) {
                Text(text = "Sepete Ekle")
            }
        }
    }

}