package com.lighttigerxiv.layout_scaffold

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass

// Information available at https://developer.android.com/develop/ui/compose/layouts/adaptive/use-window-size-classes

/** Checks if device has compact width.
 *
 * Devices: Portrait - Phone*/
@Composable
fun isCompactWidth(): Boolean {
    return currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.COMPACT
}

/** Checks if device has medium width.
 *
 * Devices: Portrait - Tablet*/
@Composable
fun isMediumWidth(): Boolean {
    return currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.MEDIUM
}

/** Checks if device has expanded width.
 *
 * Devices: Landscape - Tablet*/
@Composable
fun isExpandedWidth(): Boolean {
    return currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.EXPANDED
}

/** Checks if device has compact height.
 *
 * Devices: Landscape - Phone*/
@Composable
fun isCompactHeight(): Boolean {
    return currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass == WindowHeightSizeClass.COMPACT
}

/** Checks if device has medium height.
 *
 * Devices: Portrait - Phone, Landscape - Tablet*/
@Composable
fun isMediumHeight(): Boolean {
    return currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass == WindowHeightSizeClass.MEDIUM
}

/** Checks if device has expanded height.
 *
 * Devices: Portrait - Tablet*/
@Composable
fun isExpandedHeight(): Boolean {
    return currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass == WindowHeightSizeClass.EXPANDED
}