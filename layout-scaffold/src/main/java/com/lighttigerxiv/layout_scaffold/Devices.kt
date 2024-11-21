package com.lighttigerxiv.layout_scaffold

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.compose.runtime.Composable

/** Returns true if the available size is of a phone */
@Composable
fun isPhone(): Boolean {
    return (inPortrait() && isCompactWidth() && isMediumHeight())
            || (inPortrait() && isCompactWidth() && isExpandedHeight())
            || (inLandscape() && isCompactHeight())
}

/** Returns true if the available size is of a tablet or unfolded big foldable like Pixel 9 Pro Fold */
@Composable
fun isTablet(): Boolean {
    return !isPhone()
}

/** Returns true if the device has folding capabilities */
fun isFoldable(context: Context): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) context.packageManager.hasSystemFeature(
        PackageManager.FEATURE_SENSOR_HINGE_ANGLE
    ) else
        false
}