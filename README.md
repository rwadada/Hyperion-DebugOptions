# Hyperion-DebugOptions
[![Release](https://jitpack.io/v/rwadada/Hyperion-DebugOptions.svg)](https://jitpack.io/#rwadada/Hyperion-DebugOptions)

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
    debugImplementation 'com.github.rwadada:Hyperion-DebugOptions:1.1.0'
}
```
Developed By
-------
Ryosuke Wada (rwadada)

License
-------

    Copyright 2020 rwadada

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
