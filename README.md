# Hyperion-DebugOptions

# Usage

app/src/**debug**/AndroidManifest.xml

```xml
    <application
        android:name=".DebugApp"
        tools:replace="android:name"
        />
```


Write bindings between shared preference and method in your DebugApp.

app/src/**debug**/java/.../DebugApp.kt

```kt
// Extends your main Application classs
class DebugApp : App() {
    override fun onCreate() {
        super.onCreate()
        DebugMenu.items.addAll(listOf(
            object : SectioningItem {
                override val title: String
                    get() = "Section"
            },
            object : MenuItem {
                override val title: String
                    get() = "Menu"

                override fun onClickItem() {
                    // Do something
                }
            }
        }
    }
}
```

# Download
Step 1. Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency

```groovy
dependencies {
    debugImplementation 'com.github.rwadada:Hyperion-DebugOptions:1.0.0'
}
```
