package com.example.ecommerce_jetpack_compose.ui.screens

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerce_jetpack_compose.R
import com.example.ecommerce_jetpack_compose.ui.components.CustomSepetUrunItem
import com.example.ecommerce_jetpack_compose.ui.components.CustomTopAppBar
import com.example.ecommerce_jetpack_compose.ui.viewmodels.SepetViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun SepetScreen(sepetViewModel: SepetViewModel) {
    val sepetList by sepetViewModel.sepetList.observeAsState(emptyList())
    var textIndırımKodu by remember { mutableStateOf("") }
    var genelToplam = sepetList.sumOf { it.fiyat }
    var araToplam = sepetList.sumOf { it.fiyat }
    var genelToplamState by remember { mutableStateOf(0) }
    if (araToplam > 0) {
        genelToplam += 45
    }
    var adetToplam by remember { mutableStateOf(1) }
    genelToplamState = genelToplam
    LaunchedEffect(true) {
        sepetViewModel.loadSepetList("baro_gngr")

    }

    Scaffold(
        topBar = {
            CustomTopAppBar("TrendMağaza", yonlendir = {

            })
        },
        bottomBar = {
            Column(
                verticalArrangement = Arrangement.Bottom,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                ) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = { },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.button_renk),
                            contentColor = colorResource(R.color.white)
                        )
                    ) {
                        Text(text = "Sepeti Onayla Ve Devam Et")
                    }
                }

            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.background))
                .padding(paddingValues)
        ) {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(sepetList) { sepet ->
                    CustomSepetUrunItem(
                        sepet = sepet,
                        urunSil = {
                            sepetViewModel.urunSil(
                                sepet.sepetId,
                                sepet.kullaniciAdi
                            )

                        },
                        adet = adetToplam,
                        adetAzalt = {
                            if (adetToplam > 0)
                                adetToplam -= 1
                        },
                        adetArttir = {
                            adetToplam += 1
                        }
                    )
                }
            }

            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                Text("İndirim Kodu")
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        label = { Text(text = "Kupon kodunu girin", color = Color.LightGray) },
                        value = textIndırımKodu,
                        onValueChange = { textIndırımKodu = it },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = colorResource(id = R.color.white),
                            unfocusedContainerColor = colorResource(id = R.color.white),
                            disabledContainerColor = colorResource(id = R.color.white),
                            focusedLabelColor = colorResource(id = R.color.black),
                            cursorColor = Color.Gray,
                            focusedBorderColor = Color.Gray,
                            unfocusedBorderColor = Color.Gray,
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            if (textIndırımKodu.trim() == "techcareer") {
                                if (genelToplamState > 0) {
                                    genelToplamState -= 45
                                }
                                textIndırımKodu = ""
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Gray,
                            contentColor = Color.White,
                            disabledContainerColor = Color.LightGray,
                            disabledContentColor = Color.LightGray
                        ), shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Uygula")
                    }
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Ara Toplam", color = Color.Gray)
                        Text(text = "₺${araToplam}", color = Color.Black)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Kargo Ücreti", color = Color.Gray)
                        Text(text = "₺45", color = Color.Black)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider(modifier = Modifier, color = Color.LightGray)
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Genel Toplam",
                            fontWeight = FontWeight.Bold,
                            color = Color.DarkGray
                        )
                        Text(
                            text = "₺${genelToplamState}",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }


        }

    }
}

