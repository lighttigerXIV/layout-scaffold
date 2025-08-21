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
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.window.layout.FoldingFeature
import androidx.window.layout.WindowInfoTracker
import com.lighttigerxiv.layout_scaffold.LayoutScaffold
import com.lighttigerxiv.layout_scaffold.inLandscape
import com.lighttigerxiv.layout_scaffold.inPortrait
import com.lighttigerxiv.layout_scaffold.isCompactHeight
import com.lighttigerxiv.layout_scaffold.isCompactWidth
import com.lighttigerxiv.layout_scaffold.isExpandedHeight
import com.lighttigerxiv.layout_scaffold.isExpandedWidth
import com.lighttigerxiv.layout_scaffold.isFoldable
import com.lighttigerxiv.layout_scaffold.isMediumHeight
import com.lighttigerxiv.layout_scaffold.isMediumWidth
import com.lighttigerxiv.layout_scaffold.isPhone
import com.lighttigerxiv.layout_scaffold.isTablet
import com.lighttigerxiv.layoutscaffold.ui.theme.LayoutScaffoldTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private var isFullyOpen = false
    private var isHalfOpen = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                WindowInfoTracker.getOrCreate(this@MainActivity)
                    .windowLayoutInfo(this@MainActivity)
                    .collect { layoutInfo ->
                        val foldingFeature =
                            layoutInfo.displayFeatures.filterIsInstance<FoldingFeature>()
                                .firstOrNull()

                        isFullyOpen = foldingFeature?.state == FoldingFeature.State.FLAT
                        isHalfOpen = foldingFeature?.state == FoldingFeature.State.HALF_OPENED
                    }
            }
        }

        setContent {
            LayoutScaffoldTheme {

                val context = LocalContext.current
                val isFoldable = isFoldable(context)



                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    LayoutScaffold(
                        navigationBar = { isTablet, inLandscape ->
                            if (isTablet) {
                                Row(
                                    modifier = Modifier
                                        .width(200.dp)
                                        .fillMaxHeight()
                                        .background(MaterialTheme.colorScheme.surfaceVariant)
                                        .padding(16.dp)
                                ) {
                                    Text(
                                        if (inLandscape) "Landscape Tablet Navbar" else "Tablet Navbar",
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            } else if (inLandscape) {
                                Row(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .fillMaxHeight()
                                        .background(MaterialTheme.colorScheme.surfaceVariant)
                                        .padding(16.dp)
                                ) {
                                    Text(
                                        "Phone Landscape Navbar",
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            } else {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(70.dp)
                                        .background(MaterialTheme.colorScheme.surfaceVariant)
                                        .padding(16.dp)
                                ) {
                                    Text(
                                        "Phone Portrait Navbar",
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    ) { _, _ ->
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colorScheme.surface)
                                .padding(16.dp)
                        ) {

                            Text(
                                text = "Is Compact Width: ${isCompactWidth()}",
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Is Medium Width: ${isMediumWidth()}",
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Is Expanded Width: ${isExpandedWidth()}",
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Is Compact Height: ${isCompactHeight()}",
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Is Medium Height: ${isMediumHeight()}",
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Is Expanded Height: ${isExpandedHeight()}",
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "In Landscape: ${inLandscape()}",
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Is Portrait: ${inPortrait()}",
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Is Phone: ${isPhone()}",
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Is Tablet: ${isTablet()}",
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Is Foldable: $isFoldable",
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            if (isFoldable) {
                                Text(
                                    text = "Is Half Open: $isHalfOpen",
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "Is Fully Open: $isFullyOpen",
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

