package com.example.zomato1app.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.zomato1app.R

@Composable
fun  ProfileScreen(navController: NavController) {
    Scaffold (modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                modifier = Modifier.background(color = colorResource(R.color.white)),
                title = {},
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Arrow Back"
                        )
                    }
                }
            )
        }

    ){values ->
        Column (modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.purple_500))
            .padding(values)

        ){
            Spacer(modifier = Modifier.height(8.dp))
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .padding(horizontal = 10.dp),
                shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp,bottomStart = 0.dp, bottomEnd = 0.dp,),
                colors = CardDefaults.cardColors(Color.White)
            ){

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape),
                        painter = painterResource(id =  R.drawable.profielogo),
                        contentDescription = "profile  Image",
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Column {
                        Text(
                            text = "Name",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 23.sp
                        )
                        Text(
                            text = "nitinyadav3857@gmail.com",
                            color = Color.DarkGray,
                            fontSize = 12.sp
                        )
                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "View Activity",
                                fontSize = 13.sp,
                                color = colorResource(R.color.purple_700)
                            )
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                tint = Color.DarkGray,
                                contentDescription = "Forward Arrow",
                                modifier = Modifier.size(16.dp))
                        }
                    }
                }

            }
            //Here will  be  the lazy  Column
            ZomatoGold()
            // column_grid()
            Lazycoloumm()

        }
    }

}



@Composable
fun ZomatoGold() {
    Card (
        colors = CardDefaults.cardColors(Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .height(65.dp),
        shape = RoundedCornerShape(bottomEnd = 12.dp, bottomStart = 12.dp, topEnd = 0.dp, topStart = 0.dp)
    ){
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically

        ){
            Icon(
                painter = painterResource(R.drawable.goldicon1),
                contentDescription = "Zomato gold Image",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Join  Zomato  Gold",
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.purple_200)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Arrow  right",
                tint = Color.White
            )

        }
    }
}

@Composable
fun ColumnGrid(card: cardItem.ColoumnGrid){
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
        ){
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ){
            Column (
                modifier = Modifier.fillMaxSize()){
                Icon(
                    painter = painterResource(R.drawable.outlinebookmark24),
                    contentDescription = "Collection",
                    tint = Color.Gray,
                    modifier = Modifier
                        .padding(start = 20.dp, top = 15.dp, bottom = 5.dp)
                        .size(30.dp)
                )
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                ){
                    Text(
                        text = "Collection",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.width(10.dp))
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ){
            Column (
                modifier = Modifier.fillMaxSize()
            ){
                Icon(
                    painter = painterResource(R.drawable.rupeesymbol),
                    contentDescription = "Money",
                    tint = Color.Gray,
                    modifier = Modifier
                        .padding(start = 20.dp, top = 15.dp, bottom = 5.dp)
                        .size(30.dp)
                )
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 10.dp)

                ){
                    Text(
                        text = "Money",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Row (
                        modifier = Modifier
                            .size(width = 30.dp, height = 20.dp)
                            .background(
                                color = colorResource(R.color.purple_200),
                                shape = RoundedCornerShape(8.dp)
                            ),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "₹0",
                            color = colorResource(R.color.purple_500),
                            fontSize = 14.sp,

                        )
                    }
                }
            }
        }
    }

}



@Composable
fun Lazycoloumm() {
    val cardlist = listOf(
        cardItem.ColoumnGrid(name = "Nitin"),
        cardItem.FirstCard(Profilename = "Your  Profile", percentagetext = "48%Completed"),
        cardItem.SecondCard(vegtext = "veg Mode"),
        cardItem.ThirdCard(Apprearnece = "Appearance"),
        cardItem.FourthCard(rating = "Food Order"),
        cardItem.FifthCard(Food_Order = "Food Order"),
        cardItem.SixthCard(TittleName = "Dining and Experience"),
        cardItem.SeventhCard(Tittle = "done"),
        cardItem.EighthCard(Tittle = "done"),
        cardItem.NinthCard(Tittle = "done"),
        cardItem.TenthCard(Tittle = "done"),
        cardItem.EleventhCard(Tittle = "eleventhdone")

    )
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(cardlist) { item ->
            when (item) {
                is cardItem.ColoumnGrid -> ColumnGrid(item)
                is cardItem.FirstCard -> ProfileCard(item)
                is cardItem.SecondCard -> VegModeCard(item)
                is cardItem.ThirdCard -> AppearanceCard(item)
                is cardItem.FourthCard -> RatingCard(item)
                is cardItem.FifthCard -> FoodOrderCard(item)
                is cardItem.SixthCard -> DiningCard(item)
                is cardItem.SeventhCard -> seventhCard(item)
                is cardItem.EighthCard -> eightCard(item)
                is cardItem.NinthCard -> ninethCard(item)
                is cardItem.TenthCard -> tenthCard(item)
                is cardItem.EleventhCard -> eleventhCard(item)
            }


        }
    }


}




@Composable
fun ProfileCard(card: cardItem.FirstCard) {
    Card (modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(Color.White)
    ){
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
            ){
            Icon(imageVector = Icons.Default.AccountCircle,
                contentDescription = "Your Profile  Icon",
                modifier = Modifier.size(25.dp),
                tint = Color.LightGray)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Your Profile", color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "48% Completed",
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(12.dp))
                    .background(color = colorResource(R.color.purple_700)),
                color = colorResource(R.color.purple_700), fontWeight = FontWeight.SemiBold, fontSize = 15.sp

            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                modifier = Modifier.padding(start = 5.dp),
                tint = Color.DarkGray)


        }

    }
}

@Composable
fun  VegModeCard(card: cardItem.SecondCard) {
    var switch1 by remember { mutableStateOf(false) }
    Card (modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(Color.White)

    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(painterResource(R.drawable.veg_icon),
                contentDescription = "Veg Mode Icon",
                modifier = Modifier.size(22.dp),
                tint = colorResource(R.color.purple_200))
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = "Veg Mode", color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))
            Switch(checked = switch1, onCheckedChange = {switch1 = it},
                colors = SwitchDefaults.colors(checkedThumbColor = Color.Green),
                modifier = Modifier.height(16.dp))
        }
    }

}

@Composable
fun AppearanceCard(card: cardItem.ThirdCard) {
    Card (modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(Color.White)){
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
            ){
            Icon(
                painterResource(R.drawable.paint),
                contentDescription = "Your  Profile",
                modifier = Modifier.size(20.dp),
                tint = Color.LightGray)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text ="Appearance", color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "LIGHT",
                fontWeight = FontWeight.Bold  , color = Color.Gray )
            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "forward arrow",
                tint = Color.Gray)

        }
    }


}

@Composable
fun RatingCard(card: cardItem.FourthCard) {
    Card (modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(contentColor = Color.White)
        ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){

            Icon(
                painterResource(R.drawable.rating),
                contentDescription = "Rating Icon",
                modifier = Modifier.size(25.dp),
                tint = Color.LightGray
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Your Rating", color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painterResource(R.drawable.startrating),
                contentDescription = "star rating",
                tint = Color.Unspecified
            )
        }


    }

}

@Composable
fun FoodOrderCard(card: cardItem.FifthCard) {
    Card (modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 10.dp)
        .height(400.dp),
        colors = CardDefaults.cardColors(Color.White)
        ){
        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier
                        .height(34.dp)
                        .padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_500)
                )
                Text(text = "Food orders",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 10.dp, start = 10.dp))
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically

            ){
                //Rating  icon need to  bee  added Download
                Icon(painterResource(R.drawable.order),
                    contentDescription = "Your Orders",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "your orders", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    tint = Color.Gray)

            }
            HorizontalDivider(thickness = 0.5.dp, modifier = Modifier
                .padding(start = 53.dp, end = 10.dp)
                .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f ))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 4.dp),verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Favourites Order", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    tint = Color.Gray)

            }
            HorizontalDivider(thickness = 0.5.dp, modifier = Modifier
                .padding(start = 53.dp, end = 10.dp)
                .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f ))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 4.dp),verticalAlignment = Alignment.CenterVertically) {
                Icon(painterResource(R.drawable.thumbs),
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Favourites Order", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    tint = Color.Gray)

            }
            HorizontalDivider(thickness = 0.5.dp, modifier = Modifier
                .padding(start = 53.dp, end = 10.dp)
                .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f ))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 4.dp),verticalAlignment = Alignment.CenterVertically) {
                Icon(painterResource(R.drawable.train),
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Favourites Order", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    tint = Color.Gray)

            }
            HorizontalDivider(thickness = 0.5.dp, modifier = Modifier
                .padding(start = 53.dp, end = 10.dp)
                .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f ))


            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 4.dp),verticalAlignment = Alignment.CenterVertically) {
             Icon(painterResource(R.drawable.thumbs),
                 contentDescription = "Your Profile",
                 modifier = Modifier.size(25.dp),
                 tint = Color.LightGray)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Favourites Order", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    tint = Color.Gray)

            }
            HorizontalDivider(thickness = 0.5.dp, modifier = Modifier
                .padding(start = 53.dp, end = 10.dp)
                .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f ))

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 4.dp),verticalAlignment = Alignment.CenterVertically) {
                Icon(painterResource(R.drawable.train),
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Favourites Order", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    tint = Color.Gray)

            }
            HorizontalDivider(thickness = 0.5.dp, modifier = Modifier
                .padding(start = 53.dp, end = 10.dp)
                .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f ))

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 4.dp),verticalAlignment = Alignment.CenterVertically) {
                Icon(painterResource(R.drawable.addressbook),
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Favourites Order", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    tint = Color.Gray)

            }
            HorizontalDivider(thickness = 0.5.dp, modifier = Modifier
                .padding(start = 53.dp, end = 10.dp)
                .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f ))

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 4.dp),verticalAlignment = Alignment.CenterVertically) {
                Icon(painterResource(R.drawable.hiddden),
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Favourites Order", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    tint = Color.Gray)

            }
            HorizontalDivider(thickness = 0.5.dp, modifier = Modifier
                .padding(start = 53.dp, end = 10.dp)
                .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f ))

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 4.dp),verticalAlignment = Alignment.CenterVertically) {
                Icon(painterResource(R.drawable.message),
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Favourites Order", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    tint = Color.Gray)

            }
            Spacer(modifier = Modifier.width(4.dp))

        }
    }


}

@Composable
fun DiningCard(card: cardItem.SixthCard) {
    Card(modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp).fillMaxWidth().height(350.dp),
        colors = CardDefaults.cardColors(contentColor = Color.White)){
        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier.height(34.dp).padding(top = 12.dp).clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_500)
                )
                Text(text = "Dining and  Experiences",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                    )
            }
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painterResource(R.drawable.hiddden),
                    contentDescription = "Your orders",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Your dining Transaction ",
                    color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward  arrow",
                    tint = Color.Gray)

            }
            HorizontalDivider(thickness = 0.5.dp, modifier = Modifier.padding(start = 53.dp, end = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f))
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically){
                Icon(
                    painterResource(R.drawable.gift),
                    contentDescription = "Your orders",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward  arrow",
                    tint = Color.Gray)

            }
            HorizontalDivider(thickness = 0.5.dp, modifier = Modifier.padding(start = 53.dp, end = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f))

            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically){
                Icon(
                    painterResource(R.drawable.dining),
                    contentDescription = "Your orders",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray)
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward  arrow",
                    tint = Color.Gray)

            }

            HorizontalDivider(thickness = 0.5.dp, modifier = Modifier.padding(start = 53.dp, end = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f))

            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically){
                Icon(
                    painterResource(R.drawable.message),
                    contentDescription = "Your orders",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray)
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward  arrow",
                    tint = Color.Gray)

            }
            HorizontalDivider(thickness = 0.5.dp, modifier = Modifier.padding(start = 53.dp, end = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f))

            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically){
               Icon(imageVector = Icons.Default.Settings,
                   contentDescription = "Your Profile",
                   modifier = Modifier.size(25.dp), tint = Color.LightGray)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward  arrow",
                    tint = Color.Gray)

            }
            HorizontalDivider(thickness = 0.5.dp, modifier = Modifier.padding(start = 53.dp, end = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f))

            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically){
                Icon(imageVector = Icons.Default.Info,
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp), tint = Color.LightGray)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward  arrow",
                    tint = Color.Gray)

            }
            Spacer(modifier = Modifier.width(4.dp))
        }
    }


}

@Composable
fun  seventhCard(card: cardItem.SeventhCard) {
    Card (modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp).fillMaxWidth().height(120.dp),
        colors = CardDefaults.cardColors(contentColor = Color.White)
        ){
        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier.height(34.dp).padding(top = 12.dp).clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_700)
                )
                Text(
                    text = "Feeding  India",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp))
            }
            Row (modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically){

                Icon(painterResource(R.drawable.impact),
                    contentDescription = "Your  order ",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Your Impact", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward Arrow",
                tint = Color.Gray)
            }
            HorizontalDivider(thickness = 0.5.dp, modifier = Modifier.padding(start = 53.dp, end = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f))

            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically){
               Icon(painterResource(R.drawable.reciept), contentDescription = "Your Order ",modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                   tint = Color.LightGray)

                Text(text ="Get Feeding India receipt",
                    color =  Color.Black,
                    modifier = Modifier.padding(start = 5.dp,top =10.dp).weight(1f),)
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.Gray)


            }
        }
    }

}

@Composable
fun eightCard(card: cardItem.EighthCard) {
  Card (modifier = Modifier.padding(start = 10.dp, top = 13.dp, end = 10.dp).fillMaxWidth().height(310.dp),
      colors = CardDefaults.cardColors(contentColor = Color.White)){
      Column {
          Row {
              VerticalDivider(
                  thickness = 3.dp,
                  modifier = Modifier.height(34.dp).padding(top = 12.dp)
                      .clip(shape = RoundedCornerShape(10.dp)),
                  color = colorResource(R.color.purple_700)
              )
              Text(
                  text = "Money",
                  color = Color.Black,
                  fontWeight = FontWeight.SemiBold,
                  fontSize = 18.sp,
                  modifier = Modifier.padding(start = 10.dp, top = 10.dp)
              )

          }
          Row (modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically){

              //Rating  icon need to bee added download

              Icon(painterResource(R.drawable.rupeesymbol),
                  contentDescription = "Your Order ", modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                  tint = Color.Gray)
         }
          HorizontalDivider(thickness = 0.5.dp, modifier = Modifier.padding(start = 53.dp, end = 10.dp).weight(0.2f),
              color = Color.LightGray.copy(alpha = 0.4f))
          Row (modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically){

              //Rating  icon need to bee added download

              Icon(painterResource(R.drawable.giftcard),
                  contentDescription = "Your Order ", modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                  tint = Color.Gray)

              Text(text = "Buy  Gift  Card ", color = Color.Black, modifier = Modifier.padding(start = 5.dp, top = 10.dp).weight(1f))
              Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                  modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                  tint = Color.Gray)
          }
          HorizontalDivider(thickness = 0.5.dp, modifier = Modifier.padding(start = 53.dp, end = 10.dp).weight(0.2f),
              color = Color.LightGray.copy(alpha = 0.4f))
          Row (modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically){

              //Rating  icon need to bee added download

              Icon(painterResource(R.drawable.claimgiftcard),
                  contentDescription = "Your Order ", modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                  tint = Color.Gray)

              Text(text = "Claim Gift  Card ", color = Color.Black, modifier = Modifier.padding(start = 5.dp, top = 10.dp).weight(1f))
              Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                  modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                  tint = Color.Gray)
          }


          HorizontalDivider(thickness = 0.5.dp, modifier = Modifier.padding(start = 53.dp, end = 10.dp).weight(0.2f),
              color = Color.LightGray.copy(alpha = 0.4f))
          Row (modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically){

              //Rating  icon need to bee added download

              Icon(painterResource(R.drawable.z),
                  contentDescription = "Your Order ", modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                  tint = Color.Gray)

              Text(text = "Buy  Credits ", color = Color.Black, modifier = Modifier.padding(start = 5.dp, top = 10.dp).weight(1f))
              Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                  modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                  tint = Color.Gray)
          }

          HorizontalDivider(thickness = 0.5.dp, modifier = Modifier.padding(start = 53.dp, end = 10.dp).weight(0.2f),
              color = Color.LightGray.copy(alpha = 0.4f))
          Row (modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically){

              //Rating  icon need to bee added download

              Icon(painterResource(R.drawable.payment),
                  contentDescription = "Your Order ", modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                  tint = Color.LightGray)

              Text(text = "Payment Setting" , color = Color.Black, modifier = Modifier.padding(start = 5.dp, top = 10.dp).weight(1f))
              Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                  modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                  tint = Color.Gray)
          }

      }
  }
}

@Composable
fun ninethCard(card: cardItem.NinthCard) {
    Card(
        modifier = Modifier.padding(start = 10.dp, top = 13.dp, end = 10.dp).fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(contentColor = Color.White)
    ) {
        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier.height(34.dp).padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_700)
                )
                Text(
                    text = "Zomato For Enterprise ",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp))
            }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        painterResource(R.drawable.building),
                        contentDescription = "Your  order ",
                        modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                        tint = Color.LightGray
                    )
                    Text(
                        text = "For  employs",
                        color = Color.Black,
                        modifier = Modifier.padding(start = 5.dp, top = 10.dp).weight(1f)
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "forward arrow",
                        modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                        tint = Color.Gray
                    )


                }
                HorizontalDivider(
                    thickness = 0.5.dp,
                    modifier = Modifier.padding(start = 53.dp, end = 10.dp).weight(0.2f),
                    color = Color.LightGray.copy(alpha = 0.4f)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painterResource(R.drawable.empcard),
                        contentDescription = "Your Order ",
                        modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                        tint = Color.LightGray
                    )
                    Text(
                        text = "For  employs",
                        color = Color.Black,
                        modifier = Modifier.padding(start = 5.dp, top = 10.dp).weight(1f)
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "forward arrow",
                        modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                        tint = Color.Gray)

            }
        }
    }
}

@Composable
fun tenthCard(card: cardItem.TenthCard)  {
    Card (modifier = Modifier.padding(start = 10.dp, top = 13.dp, end = 10.dp).fillMaxWidth().height(120.dp),
        colors = CardDefaults.cardColors(contentColor = Color.White)){
        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier.height(34.dp).padding(top = 12.dp).clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_500)

                    )
                Text(
                    text = "Compons",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp,top= 10.dp)
                )

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.coupons),
                    contentDescription = "Your Order ",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.LightGray
                )
                Text(
                    text = "Collected coupons",
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp).weight(1f)
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.Gray)

            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = colorResource(R.color.purple_500)

            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.coupons),
                    contentDescription = "Your Order ",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.LightGray
                )
                Text(
                    text = "Redeem Gold coupons",
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp).weight(1f)
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.Gray
                )

            }
        }
    }

}

@Composable
fun eleventhCard(card: cardItem.EleventhCard) {
    Card (modifier = Modifier.padding(start = 10.dp, top = 13.dp, end = 10.dp).fillMaxWidth().height(300.dp),
        colors = CardDefaults.cardColors(contentColor = Color.White))
    {
        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier.height(34.dp).padding(top = 12.dp).clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_500)

                )
                Text(
                    text = "More",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp,top= 10.dp)
                )
            }
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically){
                Icon(
                    imageVector = Icons.Default.Info, contentDescription = "Your Orders", modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.LightGray
                )
                Text(text = "About", color = Color.Black, modifier = Modifier.padding(start = 5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp), tint = Color.Gray)
            }
           HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)

            )
            Row (modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically){
                Icon(
                    painterResource(R.drawable.feedback), contentDescription = "Your Profile",modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.LightGray)
                Text(text = "Send feedback ", color = Color.Black, modifier = Modifier.padding(start = 5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp,top= 10.dp),
                    tint = Color.Gray)
            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)

            )
            Row (modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically){
               Icon(imageVector = Icons.Default.Info, contentDescription = "Your Profile", modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                   tint = Color.LightGray)
                Text(text = "Report a safety emergency", color = Color.Black, modifier = Modifier.padding(start = 5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp,top= 10.dp),
                    tint = Color.Gray)
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)

            )
            Row (modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically){
                Icon(imageVector = Icons.Default.Settings, contentDescription = "Your Profile", modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.LightGray)
                Text(text = "Setting", color = Color.Black, modifier = Modifier.padding(start = 5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp,top= 10.dp),
                    tint = Color.Gray)
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)

            )
            Row (modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically){
                Icon(painterResource(R.drawable.logout), contentDescription = "Your Profile", modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.LightGray)
                Text(text = "Logout", color = Color.Black, modifier = Modifier.padding(start = 5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp,top= 10.dp),
                    tint = Color.Gray)
            }

        }

    }

}

sealed class cardItem {
    data class FirstCard(

        val Profilename: String,
        val percentagetext: String

    ) : cardItem()

    data class ColoumnGrid(val name: String)
    data class SecondCard(val vegtext: String) : cardItem()
    data class ThirdCard(val Apprearnece: String) : cardItem()
    data class FourthCard(val rating: String)
    data class FifthCard(val Food_Order: String)
    data class SixthCard(val TittleName: String)
    data class SeventhCard(val Tittle: String)
    data class EighthCard(val Tittle: String)
    data class NinthCard(val Tittle: String)
    data class TenthCard(val Tittle: String)
    data class EleventhCard(val Tittle: String)


}

@Preview(showBackground = true)
@Composable
fun PreviewProfile() {
    ProfileScreen(rememberNavController())

}



