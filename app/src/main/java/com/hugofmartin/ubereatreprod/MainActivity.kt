package com.hugofmartin.ubereatreprod

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugofmartin.ubereatreprod.ui.theme.UberEatReprodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UberEatReprodTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    Column() {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp),
                            horizontalArrangement = Arrangement.Center,

                            ) {
                            Text(text = "Livraison")
                            Spacer(modifier = Modifier.width(15.dp))
                            Text(text = "A emporter")


                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text(text = "Maintenant .")
                            Text(text = "Adresse")
                            Icon(Icons.Sharp.List, contentDescription = "")

                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun bigButtonHeader(text: String, iconId: Int) {
    Box(
        modifier = Modifier
            .height(80.dp)
            .width(170.dp)
            .background(Color.LightGray, RoundedCornerShape(5.dp))
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
            text = text
        )
    }
}

@Composable
fun smallButtonHeader() {
    Column() {
        Box(
            modifier = Modifier
                .height(74.dp)
                .width(74.dp)
                .background(Color.LightGray, RoundedCornerShape(5.dp))
        ) {
            Icon(
                painterResource(id = R.drawable.course_icon),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(50.dp)
            )
        }
        Text(text = "Hello")
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UberEatReprodTheme {
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                horizontalArrangement = Arrangement.Center,

                ) {
                Text(text = "Livraison")
                Spacer(modifier = Modifier.width(15.dp))
                Text(text = "A emporter")


            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(text = "Maintenant .")
                Text(text = "Adresse")
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
                Spacer(modifier = Modifier.width(2.dp))

                bigButtonHeader(
                    text = "Courses",
                    iconId = R.drawable.restaurant_icon
                )
            }
            Row( modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                smallButtonHeader()
                smallButtonHeader()
                Spacer(modifier = Modifier.width(2.dp))

                smallButtonHeader()
                smallButtonHeader()
            }
        }
    }
}