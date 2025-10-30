package com.example.ecommerce_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ecommerce_jetpack_compose.ui.screens.AppNavigation
import com.example.ecommerce_jetpack_compose.ui.theme.EcommercejetpackcomposeTheme
import com.example.ecommerce_jetpack_compose.ui.viewmodels.MainViewModel
import com.example.ecommerce_jetpack_compose.ui.viewmodels.SepetViewModel
import com.example.ecommerce_jetpack_compose.ui.viewmodels.UrunDetayViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val mainViewModel: MainViewModel by viewModels()
    val urunDetayViewModel: UrunDetayViewModel by viewModels()
    val sepetViewModel: SepetViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcommercejetpackcomposeTheme {
                AppNavigation(
                    mainViewModel = mainViewModel,
                    urunDetayViewModel = urunDetayViewModel,
                    sepetViewModel = sepetViewModel
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EcommercejetpackcomposeTheme {
    }
}