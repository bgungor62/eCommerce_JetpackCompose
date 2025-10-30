package com.example.ecommerce_jetpack_compose.ui.screens

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items

import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.CircularProgressIndicator

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

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ecommerce_jetpack_compose.R
import com.example.ecommerce_jetpack_compose.ui.components.CustomKategoriItem
import com.example.ecommerce_jetpack_compose.ui.components.CustomMainSliderItem
import com.example.ecommerce_jetpack_compose.ui.components.CustomTextField
import com.example.ecommerce_jetpack_compose.ui.components.CustomTopAppBar
import com.example.ecommerce_jetpack_compose.ui.components.CustomUrunlerItem
import com.example.ecommerce_jetpack_compose.ui.viewmodels.MainViewModel
import com.google.gson.Gson
import kotlin.math.log


@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel) {
    val searchQuery = remember { mutableStateOf("") }

    val urunlerList = mainViewModel.urunlerList.observeAsState(listOf())
    val kategoriListesi: List<String> = urunlerList.value.map { it.kategori }.distinct().toMutableList()
        .apply { add(0, "Tümü") } // Başa ekler
    var seciliKategori by remember { mutableStateOf("Tümü") }
    LaunchedEffect(true) {
        mainViewModel.loadUrunler()
    }
    Scaffold(topBar = {
        CustomTopAppBar("TrendMağaza", yonlendir = {
            navController.navigate("sepetScreen")
        })
    }) {

            paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(colorResource(id = R.color.background))
                .padding(paddingValues)
                .padding(all = 8.dp)
        ) {
            //Searcview
            CustomTextField(
                stringResource(R.string.search_view),
                searchQuery.value,
                onValueChange = { newValue ->
                    searchQuery.value = newValue
                })
            Spacer(modifier = Modifier.height(16.dp))
            //Sezon indirimleri
            LazyRow(
                modifier = Modifier,
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(5) {
                    CustomMainSliderItem(
                        "Sezon İndirimleri Başladı!",
                        "Tüm ürünlerde %50'ye varan indirimler."
                    )
                }
            }


            //kategoriler
            Spacer(modifier = Modifier.height(16.dp))
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Kategoriler")
                LazyRow {
                    items(kategoriListesi) { kategori ->
                        CustomKategoriItem(kategori, Icons.Outlined.Star, onClick = {
                            seciliKategori = kategori
                        })
                    }
                }
            }

            //Urunler listeleme
            if (urunlerList.value.isNullOrEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        color = colorResource(id = R.color.acik_mavi)
                    )
                }
            } else {
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    if (seciliKategori.contains("Tümü")){
                        items(urunlerList.value) {
                            val urun = it
                            CustomUrunlerItem(urun, onItemClick = {
                                //urun tıklayınca ne olacak
                                val urunJson = Gson().toJson(urun)
                                navController.navigate("urunDetayScreen/$urunJson")
                            })
                        }
                    }
                    items(urunlerList.value.filter { it.kategori == seciliKategori }) {
                        val urun = it
                        CustomUrunlerItem(urun, onItemClick = {
                            //urun tıklayınca ne olacak
                            val urunJson = Gson().toJson(urun)
                            navController.navigate("urunDetayScreen/$urunJson")
                        })
                    }
                }

            }


        }
    }
}
