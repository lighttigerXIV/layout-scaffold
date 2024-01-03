<div align="center">
  <img src="https://github.com/lighttigerXIV/layout-scaffold/assets/35658492/8d35b442-c772-407a-ad57-077e137bfb45" width="140">
  <h1>Layout Scaffold</h1>
</div>

### About
This library adds a composable to make developers life easier when it comes to have a proper layout. 
According to material3 guidelines the navbar should be on the left and not in the bottom when the device it's in landscape.
This composable can detect if the device is a tablet too which can be handy depending on how you design your app. 

### Screenshots
<details>
  <summary>Click to see the screenshots</summary>

  #### Smartphone
  <img src="https://github.com/lighttigerXIV/layout-scaffold/assets/35658492/7a4825a0-e7ed-419c-864a-e3eda7e5524f" width="200">
  <img src="https://github.com/lighttigerXIV/layout-scaffold/assets/35658492/bc24351e-a1d1-41cf-ac1c-bb317bef1651">
  
  #### Tablet
  <img src="https://github.com/lighttigerXIV/layout-scaffold/assets/35658492/63a4a809-f8a9-430d-9413-c31a1906a7ff" width="200">
  <img src="https://github.com/lighttigerXIV/layout-scaffold/assets/35658492/118b10c0-35ce-4264-9307-0a8b91f73934">
</details>



### How to add the library
#### Adding Jitpack URL
If you use Groovy DSL (settings.gradle)
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        //...
        maven { url 'https://jitpack.io' }
    }
}
```
If you use Kotlin DSL (settings.gradle):
```gradle
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
      //...
      maven("https://jitpack.io")
  }
}
```

#### Adding dependency in gradle
On your app gradle add:
```gradle
//If you use Groovy DSL
implementation 'com.github.lighttigerXIV:layout-scaffold:1.0.2'

//If you use Kotlin DSL
implementation ("com.github.lighttigerXIV:layout-scaffold:1.0.2")
```

### How to use
To use it just simply use it like this:
```kotlin
LayoutScaffold(
  portraitNavigationBar = {
      // Your portrait navbar content
  },
  landscapeNavigationBar = {
      // Your landscape navbar content
  }
){isTablet, inLandscape ->
  // Your app content
}
```

**Note:** The portraitNavigationBar and landscapeNavigationBar are optional so you may only need the following:
```kotlin
LayoutScaffold{isTablet, inLandscape ->
  // Your app content
}
```


