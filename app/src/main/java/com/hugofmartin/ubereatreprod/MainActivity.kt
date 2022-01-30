package com.hugofmartin.ubereatreprod

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.hugofmartin.ubereatreprod.data.BottomMenuItem
import com.hugofmartin.ubereatreprod.ui.HomeScreen
import com.hugofmartin.ubereatreprod.ui.component.BottomMenu
import com.hugofmartin.ubereatreprod.ui.theme.UberEatReprodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HomeScreen()
        }
    }
}


