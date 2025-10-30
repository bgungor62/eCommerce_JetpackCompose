package com.example.ecommerce_jetpack_compose.ui.screens

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ecommerce_jetpack_compose.R
import com.example.ecommerce_jetpack_compose.data.entity.Sepet
import com.example.ecommerce_jetpack_compose.data.entity.Urunler
import com.example.ecommerce_jetpack_compose.ui.components.CustomKategoriItem
import com.example.ecommerce_jetpack_compose.ui.components.CustomMainSliderItem
import com.example.ecommerce_jetpack_compose.ui.components.CustomTextField
import com.example.ecommerce_jetpack_compose.ui.components.CustomTopAppBar
import com.example.ecommerce_jetpack_compose.ui.components.CustomUrunDetayAdetSection
import com.example.ecommerce_jetpack_compose.ui.components.CustomUrunDetayBottom
import com.example.ecommerce_jetpack_compose.ui.components.CustomUrunDetayGorsel
import com.example.ecommerce_jetpack_compose.ui.components.CustomUrunHeaderSection
import com.example.ecommerce_jetpack_compose.ui.components.UcTabliArayuz
import com.example.ecommerce_jetpack_compose.ui.viewmodels.UrunDetayViewModel

@Composable
fun UrunDetayScreen(
    urun: Urunler,
    urunDetayViewModel: UrunDetayViewModel,
    navController: NavController
) {
    var rating by remember { mutableStateOf(1f) } //varsayılan derecelendirme 1 olacaktır
    var adet by remember { mutableStateOf(1) }
    var hesaplananFiyat by remember { mutableStateOf(0) }
    val crudResult by urunDetayViewModel.crudResult.collectAsState()

    val context = LocalContext.current
    val sepet =
        Sepet(0, urun.ad, urun.resim, urun.kategori, hesaplananFiyat, urun.marka, adet, "baro_gngr")



    LaunchedEffect(crudResult) {
        crudResult?.let {
            if (it.success == 1) {
                Toast.makeText(context, "Ürün Sepetinize eklenmiştir.", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(context, "Bir hata oluştu. Detay: ${it.message}", Toast.LENGTH_SHORT)
                    .show()

            }
        }
    }
    Scaffold(
        topBar = {
            CustomTopAppBar("TrendMağaza", yonlendir = {
                navController.navigate("sepetScreen")

            })
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                CustomUrunDetayBottom(urun, onClick = {
                    hesaplananFiyat = adet * urun.fiyat.toInt()
                    val sepet =
                        Sepet(
                            0,
                            urun.ad,
                            urun.resim,
                            urun.kategori,
                            hesaplananFiyat,
                            urun.marka,
                            adet,
                            "baro_gngr"
                        )
                    urunDetayViewModel.sepeteUrunEkle(sepet)
                })
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
                .background(colorResource(id = R.color.background))
                .padding(paddingValues)
                .padding(all = 16.dp)
        ) {
            CustomUrunDetayGorsel(urun)

            Spacer(modifier = Modifier.height(8.dp))

            CustomUrunHeaderSection(urun, rating, onRatingChanged = {
                rating = it
            })

            //adet artırma alanı
            CustomUrunDetayAdetSection(adet, adetAzalt = {
                if (adet > 0)
                    adet -= 1
            }, adetArttir = {
                adet += 1
            })
        }

    }
}
