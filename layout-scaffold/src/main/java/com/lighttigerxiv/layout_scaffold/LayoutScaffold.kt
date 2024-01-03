package com.lighttigerxiv.layout_scaffold

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun LayoutScaffold(
    portraitNavigationBar: @Composable RowScope.(isTablet: Boolean) -> Unit = {},
    landscapeNavigationBar: @Composable ColumnScope.(isTablet: Boolean) -> Unit = {},
    content: @Composable ColumnScope.(isTablet: Boolean, inLandscape: Boolean) -> Unit,
) {

    val configuration = LocalConfiguration.current
    val inLandscape by remember { mutableStateOf(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) }
    val isTablet by remember {
        mutableStateOf(
            if (inLandscape) {
                configuration.screenWidthDp > 1000
            } else {
                configuration.screenWidthDp > 750
            }
        )
    }

    if (inLandscape) {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxHeight()) {
                landscapeNavigationBar(isTablet)
            }
            Column(modifier = Modifier.fillMaxSize()) {
                content(isTablet, true)
            }
        }
    } else {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f, fill = true)
            ) {
                content(isTablet, false)
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                portraitNavigationBar(isTablet)
            }
        }
    }
}