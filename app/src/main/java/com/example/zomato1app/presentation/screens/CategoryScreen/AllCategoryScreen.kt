package com.example.zomato1app.presentation.screens.CategoryScreen

import com.example.zomato1app.presentation.componets.HomeScreenCard


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zomato1app.presentation.componets.ExploreRow

@Composable
fun AllCategoryScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {

        ExploreRow()
        Row(
            modifier = Modifier.padding(start = 8.dp, bottom = 8.dp, top = 16.dp),
            horizontalArrangement = Arrangement.Start
        ) {

            Column {
                Text(
                    text = "553 RESTAURANTS DELEVERING TO  YOU",
                    modifier = Modifier,
                    color = Color.Gray
                )
                Text(
                    text = "Feature",
                    modifier = Modifier.padding(start = 5.dp),
                    color = Color.Gray
                )
            }
        }

        HomeScreenCard(navController = navController)
        Spacer(modifier = Modifier.height(16.dp))
        HomeScreenCard(navController = navController)
        Spacer(modifier = Modifier.height(16.dp))
        HomeScreenCard(navController = navController)
        Spacer(modifier = Modifier.height(16.dp))
        HomeScreenCard(navController = navController)
        Spacer(modifier = Modifier.height(16.dp))
    }

}
