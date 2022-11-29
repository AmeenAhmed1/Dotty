[![](https://jitpack.io/v/AmeenAhmed1/Dotty.svg)](https://jitpack.io/#AmeenAhmed1/Dotty)

<h1>Install Dotty to your project.</h1>

Add the dependency below to your module's `build.gradle` file:

```
	dependencies {
	        implementation 'com.github.AmeenAhmed1:Dotty:1.0.0'
	}
```

<h2>How to use</h2>
You can use it in your XML like code below it will shows up with the default drawables styles.

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

<img src=screens/screenrecord.gif width="50%" height="50%"/>


<h2>Dotty Attributes (Style)</h2>

| Attribute                 |                Description                 |        Default         |
|---------------------------|:------------------------------------------:|:----------------------:|
| app:dottySelected         |          Style for selected Dotty          | _Rounded Black Circle_ |
| app:dottyUnSelected       |         Style for UnSelected Dotty         | _Rounded Gray Circle_  |
| app:dottySize             |            Size for Each Dotty             |         _10F_          |
| app:dottySpaceBetweenSize |          Size Between Each Dotty           |          _2F_          |
| app:dottyCount            |            Dotty Count to show             |          _3_           |
| app:dottyStartPosition    | Selected position when creating the layout |          _0_           |