package com.lighttigerxiv.layout_scaffold

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun inLandscape(): Boolean{
    return LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE
}

@Composable
fun inPortrait(): Boolean{
    return LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT
}