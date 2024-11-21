package com.lighttigerxiv.layout_scaffold

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.compose.runtime.Composable

@Composable
fun isPhone(): Boolean {
    return (inPortrait() && isCompactWidth() && isMediumHeight())
            || (inPortrait() && isCompactWidth() && isExpandedHeight())
            || (inLandscape() && isCompactHeight())
}

@Composable
fun isTablet(): Boolean {
    return !isPhone()
}

fun isFoldable(context: Context): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) context.packageManager.hasSystemFeature(
        PackageManager.FEATURE_SENSOR_HINGE_ANGLE
    ) else
        false
}