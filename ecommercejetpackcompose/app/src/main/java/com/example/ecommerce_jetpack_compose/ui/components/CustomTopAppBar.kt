package com.example.ecommerce_jetpack_compose.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.example.ecommerce_jetpack_compose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(title: String, yonlendir: () -> Unit) {
    CenterAlignedTopAppBar(
        title = { Text(text = title) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.background),
            titleContentColor = colorResource(id = R.color.black),
        ),
        actions = {
            IconButton(onClick = yonlendir) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart, // örnek ikon
                    contentDescription = "Ayarlar",
                    tint = colorResource(id = R.color.acik_mavi)
                )
            }
        }
    )
}