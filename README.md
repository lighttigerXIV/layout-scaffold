<div align="center">
  <img src="https://github.com/lighttigerXIV/layout-scaffold/assets/35658492/8d35b442-c772-407a-ad57-077e137bfb45" width="140">
  <h1>Layout Scaffold</h1>
</div>

# Content
- [About](#about)
- [Screenshots](#screenshots)
- [How to add the library](#how-to-add-the-library)
- [How to Use](#how-to-use)
- [How to Implement Foldables](#how-to-implement-foldables)

# About
This library adds a composable to make developers life easier when it comes to have a proper layout. 
According to material3 guidelines the navbar should be on the left and not in the bottom when the device it's in landscape.
This composable can detect if the device is a tablet too which can be handy depending on how you design your app. 

# Screenshots
<details>
  <summary>Click to see the screenshots</summary>

  #### Smartphone
  <img src="https://github.com/lighttigerXIV/layout-scaffold/assets/35658492/7a4825a0-e7ed-419c-864a-e3eda7e5524f" width="200">
  <img src="https://github.com/lighttigerXIV/layout-scaffold/assets/35658492/bc24351e-a1d1-41cf-ac1c-bb317bef1651">
  
  #### Tablet
  <img src="https://github.com/lighttigerXIV/layout-scaffold/assets/35658492/63a4a809-f8a9-430d-9413-c31a1906a7ff" width="200">
  <img src="https://github.com/lighttigerXIV/layout-scaffold/assets/35658492/118b10c0-35ce-4264-9307-0a8b91f73934">
</details>



# How to add the library
## Adding Jitpack URL
Add maven in your (settings.gradle):
```gradle
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
      // Other URLs
      maven("https://jitpack.io")
  }
}
```

## Adding dependency in gradle
On your app gradle add:
```gradle
implementation ("com.github.lighttigerXIV:layout-scaffold:2.0.2")
```
# How to use
To use it just simply use it like this:
```kotlin
LayoutScaffold(
  navigationBar = { isTablet, inLandscape ->
      // Your navbar content
  }
){isTablet, inLandscape ->
  // Your app content
}
```

> [!NOTE]
> The navigation bar is optional so you may only need the following:

```kotlin
LayoutScaffold{isTablet, inLandscape ->
  // Your app content
}
```

# Utils
To check if the device is a phone:
```kotlin
val isPhone = isPhone()
```

To check if the device is a tablet:
```kotlin
val isTablet = isTablet()
```

To check if the device is a foldable:
```kotlin
val isFoldable = isFoldable()
```

# How to Implement Foldables
I don't have a good way to make a wrapper for this so i leave here how to check if a foldable is half open, fully open or closed. It might help someone :)

## Add Window Library
```gradle
implementation("androidx.window:window:1.3.0")
```

## Add lifecycle listener in MainActivity
```kotlin
@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch{
          lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            WindowInfoTracker.getOrCreate(this@MainActivity)
              .windowLayoutInfo(this@MainActivity)
              .collect { layoutInfo ->
                // This folding feature returns the state of the folding.
                // It will return null if the device isn't a foldable or the foldable it's closed.
                val foldingFeature = layoutInfo.displayFeatures.filterIsInstance<FoldingFeature>().firstOrNull()
  
                val isFullyOpen = foldingFeature?.state == FoldingFeature.State.FLAT
                val isHalfOpen = foldingFeature?.state == FoldingFeature.State.HALF_OPENED
                val isOpen = isFullyOpen || isHalfOpen
  
                // Now you can send the data you need to your repository assuming
                // you can properly code on Android :P
              }
          }
        }
  }
}
```
