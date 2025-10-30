package com.example.ecommerce_jetpack_compose.data.entity

data class Urunler(
    val id: Int,
    val ad: String,
    val resim: String,
    val kategori: String,
    val fiyat: Int,
    val marka: String
) {
}