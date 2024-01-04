package com.lighttigerxiv.layout_scaffold

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun inLandscape(): Boolean{
    return LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE
}

@Composable
fun isTablet(): Boolean{
    val configuration = LocalConfiguration.current

    return if(inLandscape()){
        configuration.screenWidthDp > 1000
    }else{
        configuration.screenWidthDp > 750
    }
}