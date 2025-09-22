package com.example.zomato1app.presentation.componets



import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zomato1app.R
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class RestaurantPromotion(
    @DrawableRes val  imageRes: Int,
    val  name: String,
    val  tagline: String,
    val discount: String
)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun DiningSliderComponent(
    promotions: List<RestaurantPromotion>,
    modifier: Modifier = Modifier
) {
    val  pagerState = rememberPagerState(initialPage = 0){3}
    val  coroutineScope = rememberCoroutineScope()
    LaunchedEffect(pagerState) {
        while (true) {
            delay(3000)
            coroutineScope.launch {
                val nextPage =(pagerState.currentPage + 1) %promotions.size
                pagerState.animateScrollToPage(nextPage)
            }
        }

    }
    Box (
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center

    ){
        Column (
            modifier =Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 16.dp)
            ){
                Box (
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(Color.LightGray)
                )
                Text(
                    text = "DINING  SLIDER",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Light,
                    letterSpacing = 2.sp,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                Box (
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(Color.LightGray)
                )
            }
            HorizontalPager(
                pageSize = PageSize.Fill,
                state = pagerState,
                modifier = Modifier.fillMaxWidth().height(180.dp)

            ) { page ->
                val promotion = promotions[page]
                Card (
                    modifier = Modifier.fillMaxWidth().height(250.dp),
                    shape  = RoundedCornerShape(16.dp)
                ){
                    Box (
                        modifier = Modifier.fillMaxSize()
                    ){

                        Image(
                            painter = painterResource(id =  promotion.imageRes),
                            contentDescription = promotion.name,
                            modifier= modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Box (
                            modifier = Modifier.padding(12.dp)
                                .clip(RoundedCornerShape(11.dp))
                                .background(Color(0xFF0A0A0A))
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                                .align (Alignment.TopCenter)
                        ){
                            Row (verticalAlignment = Alignment.CenterVertically){
                                Image(
                                    painter = painterResource(R.drawable.discount),
                                    contentDescription = "Discount Icon",
                                    modifier = Modifier.size(14.dp)
                                )
                                Spacer(modifier =Modifier.width(4.dp))
                                Text(
                                    text = promotion.discount,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp
                                )

                            }

                        }
                        Column(
                            modifier = Modifier.align (Alignment.BottomCenter)
                                .padding(9.dp)
                        ) {

                            Box (
                                modifier = Modifier
                                    .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp,bottomEnd = 10.dp))
                                    .background(Color.White)
                                    .padding(horizontal = 16.dp, vertical = 8.dp)
                            ){
                                Text(
                                    text = promotion.name,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            }
                            Spacer(modifier = Modifier.height(1.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp,bottomStart = 10.dp))
                                    .background(Color.White)
                                    .padding(horizontal = 6.dp, vertical = 5.dp)

                            ) {
                                Text(
                                    text = promotion.tagline,
                                    fontSize = 16.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(promotions.size) { index ->
                    val color =
                        if (pagerState.currentPage == index) Color.Black else Color.Gray.copy(alpha = 0.5f)
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .size(if (pagerState.currentPage == index) 10.dp else 8.dp)
                            .clip(CircleShape)
                            .background(color)
                            .clickable {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            }

                    )
                }
            }

        }
    }

}