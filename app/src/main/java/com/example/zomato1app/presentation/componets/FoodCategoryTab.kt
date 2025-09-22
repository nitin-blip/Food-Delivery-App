package com.example.zomato1app.presentation.componets



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.zomato1app.R
import com.example.zomato1app.data.module.FoodCategoryData


@Composable
fun FoodCategoryTab(
    modifier: Modifier,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    val  categories = listOf(
        FoodCategoryData("All", R.drawable.allfood),
        FoodCategoryData("Pizza",  R.drawable.pizza_image),
        FoodCategoryData("Chinese",  R.drawable.chinese),
        FoodCategoryData("Burgers",  R.drawable.burger),
        FoodCategoryData("Biryani",  R.drawable.vegbiryani),
        FoodCategoryData("Sweets",  R.drawable.sweets),
        FoodCategoryData("pasta",  R.drawable.pasta),
        FoodCategoryData("Rolls",  R.drawable.rolls),
        FoodCategoryData("Ice Cream",  R.drawable.ice_cream),

        )
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.White,
        contentColor = Color.Black,
        edgePadding = 8.dp,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier
                    .tabIndicatorOffset(tabPositions[selectedTabIndex])
                    .height(3.dp),
                color = Color.Red
            )

        },
        divider = {
            HorizontalDivider(color = Color.LightGray, thickness = 0.6.dp)

        }

    ) {
        categories.forEachIndexed { index, category ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = {
                    onTabSelected(index)
                }

            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(8.dp)
                ){
                    AsyncImage(
                        model = category.image,
                        contentDescription = category.name,
                        modifier = Modifier.size(60.dp)
                    )
                    Text(text = category.name,
                        fontSize = 12.sp,
                        fontWeight = if(selectedTabIndex == index) FontWeight.Bold else FontWeight.Normal,
                        color = if(selectedTabIndex == index) Color.Black else Color.DarkGray

                    )
                }
            }
        }

    }
}




