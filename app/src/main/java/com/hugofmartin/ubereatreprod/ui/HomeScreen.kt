package com.hugofmartin.ubereatreprod.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hugofmartin.ubereatreprod.R
import com.hugofmartin.ubereatreprod.data.BottomMenuItem
import com.hugofmartin.ubereatreprod.data.Restaurant
import com.hugofmartin.ubereatreprod.ui.component.BottomMenu
import com.hugofmartin.ubereatreprod.ui.component.RestaurantList
import com.hugofmartin.ubereatreprod.ui.component.TypeButtonList
import kotlin.math.roundToInt


@Composable
fun OrderTypeMenuSection(orderType: List<String>, modifier: Modifier) {

    var selectedOrderType by remember {
        mutableStateOf(0)
    }
    Box(modifier = modifier) {
        LazyRow(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxWidth()
                .height(36.dp),
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
                        color = if (selectedOrderType == it) Color.White
                        else Color.Black
                    )
                }
            }
        }
    }


}

@Composable
fun HomeScreen() {

    val toolbarHeight = 36.dp
    val toolbarHeightPx = with(LocalDensity.current) { toolbarHeight.roundToPx().toFloat() }

    val toolbarOffsetHeightPx =
        remember { mutableStateOf(0f) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = toolbarOffsetHeightPx.value + delta
                toolbarOffsetHeightPx.value = newOffset.coerceIn(-toolbarHeightPx, 0f)
                return Offset.Zero
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomMenu(
                listOf(
                    BottomMenuItem("Accueil", R.drawable.ic_home),
                    BottomMenuItem("Parcourir", R.drawable.ic_search_list),
                    BottomMenuItem("Offres", R.drawable.ic_offer),
                    BottomMenuItem("Commandes", R.drawable.ic_order),
                    BottomMenuItem("Compte", R.drawable.ic_profile)
                ),
                0
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .nestedScroll(nestedScrollConnection)
        ) {
            OrderTypeMenuSection(
                listOf("Livraison", "A emporter"),
                Modifier.offset(x = 0.dp, y = toolbarOffsetHeightPx.value.roundToInt().dp)
            )

            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .padding(start = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Maintenant")
                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    painterResource(id = R.drawable.icon_point),
                    contentDescription = "separation point",
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "36 Rue des A...")
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painterResource(id = R.drawable.ic_chevrons),
                    contentDescription = "separation point",
                    tint = Color.Black,
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    painterResource(id = R.drawable.ic_filter_slider),
                    contentDescription = "",
                    tint = Color.Black,
                )

            }
            LazyColumn() {
                item {
                    TypeButtonList()
                    Spacer(
                        modifier = Modifier
                            .height(4.dp)
                            .background(Color.LightGray)
                    )
                    RestaurantList(
                        listOf(
                            Restaurant(
                                "BIOBURGER",
                                "Part Dieu",
                                true,
                                R.drawable.photo_bioburger,
                                "4.4",
                                "25-35 min",
                                true
                            ),
                            Restaurant(
                                "BIOBURGER",
                                "Part Dieu",
                                true,
                                R.drawable.photo_bioburger,
                                "4.4",
                                "25-35 min",
                                true
                            ),
                            Restaurant(
                                "BIOBURGER",
                                "Part Dieu",
                                true,
                                R.drawable.photo_bioburger,
                                "4.4",
                                "25-35 min",
                                true
                            ),
                            Restaurant(
                                "BIOBURGER",
                                "Part Dieu",
                                true,
                                R.drawable.photo_bioburger,
                                "4.4",
                                "25-35 min",
                                true
                            )
                        )
                    )
                }
            }


        }
    }
}