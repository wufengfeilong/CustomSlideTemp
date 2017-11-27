 # CustomSlideTemperature
 
 **1.Import** 
 
 Step 1. Add the JitPack repository to your build file.
 
 Add it in your **root** build.gradle at the end of repositories:
 
 ```
 allprojects {
     repositories {
         jcenter()
         maven { url 'https://jitpack.io' }
     }
 }
 ```
 Step 2. Add the dependency
 
 Add it in your **module** build.gradle at the end of dependencies:
 ```
 dependencies {
 		compile 'com.github.wufengfeilong:CustomSlideTemp:1.0'
 	}
 ```
 **2.Usage**
 
 Step 1.Add DoubleDatePicker to your layout xml file.
  ```
 <lohas.slidetemp.CustomSlideTempView
             android:id="@+id/slide_temp"
             android:layout_width="match_parent"
             android:layout_height="100dp"/>
 ```
  Step 2.Declare DoubleDatePicker and Relation it.
   ```
  CustomSlideTempView cst;
  ```
  ```
  cst = (CustomSlideTempView) findViewById(R.id.slide_temp);
  ```
 **3.Provided Method**
 
 `getCurrentTempVal()`: get current temperature
 
 `setTempSection(double min, double max)`: set temperature section 