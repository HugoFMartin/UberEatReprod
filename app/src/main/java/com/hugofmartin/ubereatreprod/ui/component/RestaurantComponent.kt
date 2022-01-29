package com.hugofmartin.ubereatreprod.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hugofmartin.ubereatreprod.data.Restaurant
import com.hugofmartin.ubereatreprod.R


@Composable
fun RestaurantList(list: List<Restaurant>){
    Column(){
        list.forEach{
            RestaurantComponent(restaurant = it)
        }
    }
}

@Composable
fun RestaurantComponent(restaurant: Restaurant) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(8.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ) {
            Image(
                painter = painterResource(restaurant.photo),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillWidth
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f)
                    .padding(top = 10.dp, end = 10.dp),
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            colorResource(id = R.color.green),
                            RoundedCornerShape(topEnd = 15.dp, bottomEnd = 15.dp)
                        )
                        .fillMaxWidth(0.9f)
                        .fillMaxHeight()
                ) {
                    if (restaurant.hasPromotion)Text(
                        text = "Plus que 3 commandes pour gagner 5 €",
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = Color.White
                )
            }


        }
        Box(
            modifier = Modifier.fillMaxWidth()

        ) {
            Text(
                text = restaurant.rating,
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.TopEnd)
                    .background(Color.LightGray, RoundedCornerShape(15.dp))
                    .padding(4.dp),
            )
            Column(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .height(120.dp)
            ) {

                Text(
                    text = restaurant.title +" - " + restaurant.location,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 2.dp)
                )
                Row(
                    modifier = Modifier.padding(vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (restaurant.sponsored) {
                        Text(
                            text = "Sponsorisé",
                            style = TextStyle(textDecoration = TextDecoration.Underline)
                        )
                        Icon(
                            painterResource(id = R.drawable.icon_point),
                            contentDescription = "separation point",
                        )
                    }
                    Icon(
                        painterResource(id = R.drawable.ic_ticket),
                        contentDescription = "ticket icon",
                        modifier =Modifier.size(20.dp),
                        tint= colorResource(id = R.color.green),
                    )
                    Text(
                        text = "Frais de livraison à 0€ .",
                    )
                }
                Text(
                    text = restaurant.delivery_time,
                    modifier = Modifier.padding(vertical = 2.dp)
                )
            }

        }

    }
}