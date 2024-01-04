package com.lighttigerxiv.layoutscaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lighttigerxiv.layout_scaffold.LayoutScaffold
import com.lighttigerxiv.layoutscaffold.ui.theme.LayoutScaffoldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutScaffoldTheme {
                LayoutScaffold(
                    portraitNavigationBar = {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp)
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                            .padding(16.dp)
                        ) {
                            Text(text = "Navbar", color = MaterialTheme.colorScheme.onSurface)
                        }
                    },
                    landscapeNavigationBar = {
                        Column(modifier = Modifier
                            .fillMaxHeight()
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                            .padding(16.dp)
                        ) {
                            Text(text = "Navbar", color = MaterialTheme.colorScheme.onSurface)
                        }
                    }
                ){isTablet, inLandscape ->
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                    ) {

                        Text(text = "Is Tablet: $isTablet", color = MaterialTheme.colorScheme.onSurface)
                        Text(text = "In Landscape: $inLandscape", color = MaterialTheme.colorScheme.onSurface)
                    }
                }
            }
        }
    }
}

