package com.hugofmartin.ubereatreprod.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hugofmartin.ubereatreprod.R

@Composable
fun TypeButtonList(){
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
            .fillMaxWidth(),
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


        Spacer(modifier = Modifier.width(20.dp))
        smallButtonHeader(
            text = "Hygiène",
            iconId = R.drawable.hygiene
        )
        smallButtonHeader(
            text = "Tout afficher",
            null
        )
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
        )
    }
}

@Composable
fun smallButtonHeader(text: String, iconId: Int?) {
    Column {
        Box(
            modifier = Modifier
                .height(82.dp)
                .width(82.dp)
                .align(Alignment.CenterHorizontally)
                .background(colorResource(id = R.color.light_gray), RoundedCornerShape(5.dp))
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
                    painterResource(id = R.drawable.ic_points),
                    contentDescription = "",
                    modifier = Modifier
                        .size(22.dp)
                        .align(Alignment.Center)
                )
            }

        }
        Text(
            text = text,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(74.dp)
                .padding(top = 8.dp)
        )
    }
}