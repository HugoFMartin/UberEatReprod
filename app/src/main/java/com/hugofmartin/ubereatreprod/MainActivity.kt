package com.hugofmartin.ubereatreprod

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.sharp.List
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hugofmartin.ubereatreprod.ui.theme.UberEatReprodTheme

class MainActivity : ComponentActivity() {
    private val fontFamily = FontFamily(
        Font(R.font.spline_sans_light, FontWeight.Light),
        Font(R.font.spline_sans_medium, FontWeight.Medium),
        Font(R.font.spline_sans_semi_bold, FontWeight.SemiBold),
        Font(R.font.spline_sans_bold, FontWeight.Bold)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UberEatReprodTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    UberEatReprodTheme {
                        Column {
                            OrderTypeMenuSection(listOf("Livraison", "A emporter"))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                            ) {
                                Text(text = "Maintenant .", fontFamily = fontFamily)
                                Text(text = "Adresse", fontFamily = fontFamily)
                                Icon(Icons.Sharp.List, contentDescription = "")

                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {

                                bigButtonHeader(
                                    text = "Restaurants",
                                    iconId = R.drawable.course_icon
                                )
                                bigButtonHeader(
                                    text = "Courses",
                                    iconId = R.drawable.restaurant_icon
                                )
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                smallButtonHeader(
                                    text = "Épicerie",
                                    iconId = R.drawable.epicerie
                                )
                                smallButtonHeader(
                                    text = "Alcool",
                                    iconId = R.drawable.alcool
                                )


                                smallButtonHeader(
                                    text = "Hygiène",
                                    iconId = R.drawable.hygiene
                                )
                                smallButtonHeader(
                                    text = "Tout afficher",
                                    null
                                )
                            }
                            Spacer(
                                modifier = Modifier
                                    .height(4.dp)
                                    .background(Color.LightGray)
                            )
                            restaurantItem()
                            restaurantItem()
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun OrderTypeMenuSection(orderType: List<String>) {

        var selectedOrderType by remember {
            mutableStateOf(0)
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.Center,

            ) {
            items(orderType.size) {
                Box(modifier = Modifier
                    .padding(end = 15.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(
                        if (selectedOrderType == it) Color.Black
                        else Color.White
                    )
                    .padding(top = 8.dp, bottom = 8.dp, start = 15.dp, end = 15.dp)
                    .clickable {
                        selectedOrderType = it
                    }
                ) {
                    Text(
                        text = orderType[it],
                        fontFamily = fontFamily,
                        color = if (selectedOrderType == it) Color.White
                        else Color.Black
                    )
                }
            }
        }

    }

    @Composable
    fun bigButtonHeader(text: String, iconId: Int) {
        Box(
            modifier = Modifier
                .height(90.dp)
                .width(170.dp)
                .background(colorResource(id = R.color.light_gray), RoundedCornerShape(5.dp))
        ) {
            Icon(
                painterResource(id = iconId),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(end = 8.dp, top = 8.dp)
                    .size(50.dp)
            )
            Text(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 12.dp, bottom = 6.dp),
                text = text,
                fontFamily = fontFamily,
            )
        }
    }

    @Composable
    fun restaurantItem() {

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
                    painter = painterResource(R.drawable.photo_bioburger),
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
                        Text(
                            text = "Plus que 3 commandes pour gagner 5 €",
                            color = Color.White,
                            modifier = Modifier
                                .padding(start = 10.dp)
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
                    text = "4.4",
                    fontFamily = fontFamily,
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
                        text = "BIOBURGER - Part-Dieu",
                        fontWeight = FontWeight.Bold,
                        fontFamily = fontFamily,
                        modifier = Modifier.padding(vertical = 2.dp)
                    )
                    Row(
                        modifier = Modifier.padding(vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Sponsorisé",
                            fontFamily = fontFamily,
                            style = TextStyle(textDecoration = TextDecoration.Underline)
                        )
                        Icon(
                            painterResource(id = R.drawable.icon_point),
                            contentDescription = "separation point"
                        )
                        Icon(
                            painterResource(id = R.drawable.icon_ticket),
                            contentDescription = "ticket icon",
                            Modifier.size(20.dp)
                        )
                        Text(
                            text = "Frais de livraison à 0€ .",
                            fontFamily = fontFamily,
                        )
                    }
                    Text(
                        text = "25-35 min",
                        fontFamily = fontFamily,
                        modifier = Modifier.padding(vertical = 2.dp)
                    )
                }

            }

        }

    }

    @Composable
    fun smallButtonHeader(text: String, iconId: Int?) {
        Column{
            Box(
                modifier = Modifier
                    .height(74.dp)
                    .width(74.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray, RoundedCornerShape(5.dp))
            ) {
                if (iconId != null) {
                    Icon(
                        painterResource(id = iconId),
                        contentDescription = "",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                } else {
                    Icon(
                        Icons.Filled.MoreVert,
                        contentDescription = "",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }

            }
            Text(
                text = text,
                fontSize = 12.sp,
                fontFamily = fontFamily,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(74.dp)
                    .padding(top = 8.dp)
            )
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        UberEatReprodTheme {
            Column {
                OrderTypeMenuSection(listOf("Livraison", "A emporter"))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Maintenant", fontFamily = fontFamily)
                    Icon(
                        painterResource(id = R.drawable.icon_point),
                        contentDescription = "separation point"
                    )
                    Text(text = "Adresse", fontFamily = fontFamily)
                    Icon(Icons.Sharp.List, contentDescription = "")
                }
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    bigButtonHeader(
                        text = "Restaurants",
                        iconId = R.drawable.course_icon
                    )
                    bigButtonHeader(
                        text = "Courses",
                        iconId = R.drawable.restaurant_icon
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    smallButtonHeader(
                        text = "Épicerie",
                        iconId = R.drawable.epicerie
                    )
                    Spacer(modifier = Modifier.width(22.dp))
                    smallButtonHeader(
                        text = "Alcool",
                        iconId = R.drawable.alcool
                    )
                    Spacer(modifier = Modifier.width(36.dp))
                    smallButtonHeader(
                        text = "Commerces de bouches",
                        iconId = R.drawable.hygiene
                    )
                    Spacer(modifier = Modifier.width(22.dp))
                    smallButtonHeader(
                        text = "Tout afficher",
                        null
                    )
                }
                Spacer(
                    modifier = Modifier
                        .height(4.dp)
                        .background(Color.LightGray)
                )
                restaurantItem()
                restaurantItem()
            }
        }
    }

}


