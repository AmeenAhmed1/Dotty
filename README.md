[![](https://jitpack.io/v/AmeenAhmed1/Dotty.svg)](https://jitpack.io/#AmeenAhmed1/Dotty)

# <div style="text-align: center;"> A Minimal Lib for creating an indicator </div>

# <h1>Install Dotty to your project.</h1>

Add the dependency below to your module's `build.gradle` file:

```groovy
    dependencies {
    implementation 'com.github.AmeenAhmed1:Dotty:1.0.0'
}
```

# <h2>How to use</h2>

You can use it in your XML like code below it will show up with the default drawables styles.

```xml

<com.github.ameen.dottylib.Dotty
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
```

You can change the Dotty layout

```xml

<com.github.ameen.dottylib.Dotty
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:dottySelected="@drawable/your_drawable_file"
        app:dottyUnSelected="@drawable/your_drawable_file"
        app:dottySize="2dp"
        app:dottySpaceBetweenSize="2dp"
        app:dottyCount="5"
        app:dottyStartPosition="3"/>
```

# <h2>How to handle Dotty selection within the Code</h2>

```kotlin
//Provide your steps counter.
binding.dotty.setIndicatorCount(adapter.itemCount)

//Provide selected position.
binding.dotty.selectCurrentPosition(position)
```

<div style="text-align: center;"> <img src=screens/screenrecord.gif width="20%" height="20%"/> </div>


<h2>Dotty Attributes (Style)</h2>

| Attribute                 |                Description                 |        Default         |
|---------------------------|:------------------------------------------:|:----------------------:|
| app:dottySelected         |          Style for selected Dotty          | _Rounded Black Circle_ |
| app:dottyUnSelected       |         Style for UnSelected Dotty         | _Rounded Gray Circle_  |
| app:dottySize             |            Size for Each Dotty             |         _10F_          |
| app:dottySpaceBetweenSize |          Size Between Each Dotty           |          _2F_          |
| app:dottyCount            |            Dotty Count to show             |          _3_           |
| app:dottyStartPosition    | Selected position when creating the layout |          _0_           |