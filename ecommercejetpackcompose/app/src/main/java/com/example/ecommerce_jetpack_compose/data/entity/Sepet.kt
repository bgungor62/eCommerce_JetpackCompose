package com.example.ecommerce_jetpack_compose.data.entity

data class Sepet(
    val sepetId: Int,
    val ad: String,
    val resim: String,
    val kategori: String,
    val fiyat: Int,
    val marka: String,
    val siparisAdeti: Int,
    val kullaniciAdi: String
) {

}