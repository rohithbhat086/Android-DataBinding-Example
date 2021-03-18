# Android-DataBinding-Example
Example app demonstrating the use of androidx Data Binding feature 

Data Binding:
Data binding is used to create an object that binds two pieces of information together at compile time, so that you don't have to look for it at runtime.

Data Binding vs findViewById
findViewById is a costly operation because it traverses the view hierarchy every time it is called.
With data binding enabled, the compiler creates references to all views in a <layout> that have an id, and gathers them in a Binding object.
In your code, you create an instance of the binding object, and then reference views through the binding object with no extra overhead.

Steps:
1. Enable data binding in your build.gradle file in the app module inside the android section:
```
  dataBinding {
    enabled = true
  }
```
2. Wrap all views in your layout xml file into a <layout> tag.
```
  <layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
    <LinearLayout
        ...
        >
      ...
    </LinearLayout>
  </layout>
```
3. In your Activity class, create a binding object. If your layout xml file name is activity_my_launcher.xml, create an object of ActivityMyLauncherBinding
```
  private lateinit var mBinding : ActivityMyLauncherBinding
  ...
  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_my_launcher)
        ...
  ...
```
4. Use the mBinding object to replace all calls to findViewById, for example:
```
  mBinding.editData.setOnClickListener...
```
5. You can bind a data object into your layout xml as below:
```
  <data>
        <variable
            name="mCandidate"
            type="com.rgb.example.databinding.data.User" />
  </data>
```
6. You can use this data object to set values to view attributes as below:
```
  android:text="@{mCandidate.yearsOfExp}"
```
7. From your activity you can set the xml's data variable as below:
```
  mUser = User()
  mBinding.mCandidate = mUser
```
8. As and when the data object gets changed, you can update it and call ```invalidateAll()``` on binding object, so that the views can take updated values.
