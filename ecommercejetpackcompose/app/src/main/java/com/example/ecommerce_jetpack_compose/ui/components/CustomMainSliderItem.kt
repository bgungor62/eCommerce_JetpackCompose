package com.example.ecommerce_jetpack_compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ecommerce_jetpack_compose.R

@Composable
fun CustomMainSliderItem(text1: String,text2: String){
    Box(
        modifier = Modifier
            .height(220.dp)
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(    modifier = Modifier
                .width(300.dp) // Sabit genişlik
            ) {
                Image(
                    painter = painterResource(id = R.drawable.unnamed),
                    contentDescription = null,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.fillMaxSize().background(colorResource(R.color.white)).padding(8.dp)) {
                    Text(text = text1)
                    Text(text = text2)
                }
            }


        }

    }
}