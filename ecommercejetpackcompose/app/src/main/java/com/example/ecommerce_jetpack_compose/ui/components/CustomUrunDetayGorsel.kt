package com.example.ecommerce_jetpack_compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ecommerce_jetpack_compose.R
import com.example.ecommerce_jetpack_compose.data.entity.Urunler
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CustomUrunDetayGorsel(urun: Urunler) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
        ) {
            val url = "http://kasimadalan.pe.hu/urunler/resimler/${urun.resim}"
            GlideImage(
                imageModel = url,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop

            )
        }
        /*Image(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .aspectRatio(1f),
            painter = painterResource(id = R.drawable.unnamed),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )*/
    }
}