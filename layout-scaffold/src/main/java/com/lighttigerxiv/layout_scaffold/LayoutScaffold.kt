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
    navigationBar: @Composable ColumnScope.(isTablet: Boolean, inLandscape: Boolean) -> Unit = { _, _ -> },
    content: @Composable ColumnScope.(isTablet: Boolean, inLandscape: Boolean) -> Unit,
) {

    val inPortrait = inPortrait()
    val isTablet = isTablet()

    if (inPortrait) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f, fill = true)
            ) {
                content(isTablet, false)
            }
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                navigationBar(isTablet, false)
            }
        }
    } else {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxHeight()
            ) {
                navigationBar(isTablet, true)
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f, fill = true)
            ) {
                content(isTablet, true)
            }
        }
    }
}