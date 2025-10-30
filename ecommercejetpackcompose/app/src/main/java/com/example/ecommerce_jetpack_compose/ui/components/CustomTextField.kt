package com.example.ecommerce_jetpack_compose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ecommerce_jetpack_compose.R

@Composable
fun CustomTextField(hint: String, value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = hint) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        leadingIcon = { Icon(
            Icons.Filled.Search,
            contentDescription = "Search Field",
            tint = colorResource(id = R.color.black))
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = colorResource(id = R.color.white),
            unfocusedContainerColor = colorResource(id = R.color.white),
            disabledContainerColor = colorResource(id = R.color.white),
            focusedLabelColor = colorResource(id = R.color.black),
            cursorColor = colorResource(id = R.color.black),
            focusedBorderColor = colorResource(id = R.color.background),
            unfocusedBorderColor = colorResource(id = R.color.white),
        )
    )
}