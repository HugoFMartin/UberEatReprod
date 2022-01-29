package com.hugofmartin.ubereatreprod.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hugofmartin.ubereatreprod.data.BottomMenuItem

@Composable
fun BottomMenu(items: List<BottomMenuItem>, initialSelectedItem: Int = 0) {

    var selectedItem by remember {
        mutableStateOf(initialSelectedItem)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(item, index == selectedItem) {
                selectedItem = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item : BottomMenuItem,
    selected: Boolean,
    onItemClick: () -> Unit ) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onItemClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally),
        ) {
            Icon(
                painterResource(id = item.icon),
                tint = if(selected) Color.Black else Color.LightGray,
                contentDescription = "Bottom menu icon" )
        }
        Text(
            text = item.text,
            color = if(selected) Color.Black else Color.LightGray )
    }

}