package com.example.ecommerce_jetpack_compose.data.entity

import com.google.gson.annotations.SerializedName

data class SepetResponse(
    @SerializedName("urunler_sepeti")
    val sepet: List<Sepet>, val success: Int) {
}