package com.example.ecommerce_jetpack_compose.ui.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ecommerce_jetpack_compose.R
import com.example.ecommerce_jetpack_compose.data.entity.Urunler
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CustomUrunlerItem(urun: Urunler, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .height(220.dp)
            .width(150.dp)
            .clickable {
                onItemClick()
            }
    ) {
        Column(
            modifier = Modifier
                .background(colorResource(R.color.white))
                .padding(8.dp)
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    val url = "http://kasimadalan.pe.hu/urunler/resimler/${urun.resim}"
                    GlideImage(
                        imageModel = url,
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(100.dp),
                        contentScale = ContentScale.Fit

                    )
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .offset(x = (0).dp, y = (-32).dp)
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(
                                colorResource(R.color.white)
                            )
                            .border(1.dp, Color.LightGray, CircleShape)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.heartoutlined),
                            contentDescription = null,
                            modifier = Modifier,
                            contentScale = ContentScale.Crop
                        )

                    }
                }
            }

            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom,
            ) {
                Text(text = urun.ad, style = MaterialTheme.typography.bodyMedium)
                Text(text = urun.kategori, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.secondary)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "${urun.fiyat} TL", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.primary)
            }

        }

    }
}
