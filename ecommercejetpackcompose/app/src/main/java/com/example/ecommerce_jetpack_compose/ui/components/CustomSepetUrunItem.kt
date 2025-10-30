package com.example.ecommerce_jetpack_compose.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerce_jetpack_compose.R
import com.example.ecommerce_jetpack_compose.data.entity.Sepet
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CustomSepetUrunItem(
    sepet: Sepet,
    urunSil: () -> Unit,
    adet: Int,
    adetAzalt: () -> Unit,
    adetArttir: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .size(150.dp)
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.white)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Row {
            Card(
                modifier = Modifier.padding(16.dp), colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray
                )
            ) {
                var url = "http://kasimadalan.pe.hu/urunler/resimler/${sepet.resim}"
                GlideImage(
                    imageModel = url,
                    contentDescription = null,
                    modifier = Modifier.size(100.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Column(modifier = Modifier) {
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(sepet.ad)
                    Icon(
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .clickable {
                                urunSil()
                            },
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = "Sepet",
                        tint = Color.Gray
                    )
                }
                Text(text = sepet.kategori, color = Color.Gray)
                Text("₺${sepet.fiyat}", color = Color.Blue)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                   /* Button(
                        onClick = adetAzalt,
                        modifier = Modifier.size(32.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                        contentPadding = PaddingValues(0.dp) // İç boşluğu sıfırla
                    ) {
                        Text(text = "-", fontSize = 16.sp)
                    }*/

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(text = "${sepet.siparisAdeti} Adet", fontSize = 16.sp)

                    Spacer(modifier = Modifier.width(8.dp))

                    /*Button(
                        onClick = adetArttir,
                        modifier = Modifier.size(32.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(text = "+", fontSize = 16.sp)
                    }*/
                }
            }

        }

    }
}