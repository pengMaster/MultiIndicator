# ViewPager指示器有这一篇就够了
多功能指示器，适用于ViewPager 多场景
 - 传统的文字+指示器组合
 - 单纯的指示器
 - 圆点轮播指示器

## 1.传统的文字+指示器组合
<div>
    <img src="https://github.com/pengMaster/picApplyGit/blob/master/MultiIndicator/ic_tabLayout.gif"   alt=""/>
    <img src="https://github.com/pengMaster/picApplyGit/blob/master/MultiIndicator/ic_tabLayout_1.png" width="200" height="300"  alt=""/>
    <img src="https://github.com/pengMaster/picApplyGit/blob/master/MultiIndicator/ic_tabLayout_2.png" width="200" height="300"  alt=""/>
</div>

xml:
```java
            <com.example.indicatorlib.views.TabLayout
                android:id="@+id/nts_top"
                android:layout_width="match_parent"
                android:layout_height="56dp"
                android:layout_gravity="center"
                app:nts_active_color="#42a4d1"
                app:nts_color="#42a4d1"
                app:nts_corners_radius="1dp"
                app:nts_inactive_color="#ff1a1e23"
                app:nts_size="15sp"
                app:nts_titles="@array/titles"
                app:nts_weight="3dp"/>
```
java:
```java
        List<Fragment> lists = new ArrayList<>();
        Fragment fragment1 = new TestFragment();
        Fragment fragment2 = new TestFragment();
        Fragment fragment3 = new TestFragment();
        lists.add(fragment1);
        lists.add(fragment2);
        lists.add(fragment3);
        BaseFragmentAdapter adapter = new BaseFragmentAdapter(getSupportFragmentManager(),lists);
        mViewPager.setAdapter(adapter);
        mCenterTabLayout.setViewPager(mViewPager, 1);
```
扩展属性：
```java
            mTabLayout.setTitles("Tab1", "Tab2", "Tab3");
            mTabLayout.setTabIndex(0, true);
            mTabLayout.setTitleSize(15);
            mTabLayout.setStripColor(Color.RED);
            mTabLayout.setStripWeight(6);
            mTabLayout.setStripFactor(2);
            mTabLayout.setStripType(TabLayout.StripType.LINE);
            mTabLayout.setStripGravity(TabLayout.StripGravity.BOTTOM);
            mTabLayout.setTypeface("fonts/typeface.ttf");
            mTabLayout.setCornersRadius(3);
            mTabLayout.setAnimationDuration(300);
            mTabLayout.setInactiveColor(Color.GRAY);
            mTabLayout.setActiveColor(Color.WHITE);
            mTabLayout.setOnPageChangeListener(...);
            mTabLayout.setOnTabStripSelectedIndexListener(...);
```

```
    如果产品经理再次提出了`花里胡哨`的需求，那么上面的指示器就无法满足要求，为了高度解耦，
    我们单纯的把指示器拿出来，然后我们就可以肆意妄为了，如下：
```
## 2.单纯的指示器
<div>
    <img src="https://github.com/pengMaster/picApplyGit/blob/master/MultiIndicator/ic_tabView.gif" width="150" height="250"  alt=""/>
    <img src="https://github.com/pengMaster/picApplyGit/blob/master/MultiIndicator/ic_tabView_1.png" width="150" height="250"  alt=""/>
    <img src="https://github.com/pengMaster/picApplyGit/blob/master/MultiIndicator/ic_tabView_2.png" width="150" height="250"  alt=""/>
    <img src="https://github.com/pengMaster/picApplyGit/tree/master/MultiIndicator/anim_none.gif"  width="150" height="250" alt=""/>
</div>

xml:
```java

            <com.example.indicatorlib.views.TabView
                android:id="@+id/mIndicator"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:background="@color/white"
                app:tabHeight="3dp"
                app:tabColor="@color/red"
                app:tabRadius="20dp"
                >

            </com.example.indicatorlib.views.TabView>

            <android.support.v4.view.ViewPager
                android:id="@+id/vpPersonManager"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:background="@color/white_f2">

            </android.support.v4.view.ViewPager
```
java:
```java
        List<Fragment> lists = new ArrayList<>();
        Fragment fragment1 = new TestFragment();
        Fragment fragment2 = new TestFragment();
        lists.add(fragment1);
        lists.add(fragment2);
        BaseFragmentAdapter adapter = new BaseFragmentAdapter(getSupportFragmentManager(),lists);
        ViewPager vpPersonManager = findViewById(R.id.vpPersonManager);
        TabView tabView = findViewById(R.id.mIndicator);
        vpPersonManager.setAdapter(adapter);
        tabView.setViewPager(vpPersonManager);
```
扩展属性：
```java
        app:tabHeight="3dp"
        app:tabColor="@color/red"
        app:tabRadius="20dp"
```

## 3.圆点轮播指示器

扩展属性以及效果图：

Name| Support version| Preview
-------- | --- | ---
`AnimationType.NONE`| 0.0.1 | ![anim_none](https://github.com/pengMaster/picApplyGit/tree/master/MultiIndicator/anim_none.gif)
`AnimationType.COLOR`| 0.0.1 |![anim_color](https://github.com/pengMaster/picApplyGit/tree/master/MultiIndicator/anim_color.gif)
`AnimationType.SCALE`| 0.0.1 |![anim_scale](https://github.com/pengMaster/picApplyGit/tree/master/MultiIndicator/anim_scale.gif)
`AnimationType.SLIDE`| 0.0.1 |![anim_slide](https://github.com/pengMaster/picApplyGit/tree/master/MultiIndicator/anim_slide.gif)
`AnimationType.WORM`| 0.0.1 |![anim_worm](https://github.com/pengMaster/picApplyGit/tree/master/MultiIndicator/anim_worm.gif)
`AnimationType.FILL`| 0.0.1 |![anim_worm](https://github.com/pengMaster/picApplyGit/tree/master/MultiIndicator/anim_fill.gif)
`AnimationType.THIN_WORM`| 0.0.1 |![anim_thin_worm](https://github.com/pengMaster/picApplyGit/tree/master/MultiIndicator/anim_thin_worm.gif)
`AnimationType.DROP`| 0.0.1 |![anim_drop](https://github.com/pengMaster/picApplyGit/tree/master/MultiIndicator/anim_drop.gif)
`AnimationType.SWAP`| 0.0.1 |![anim_swap](https://github.com/pengMaster/picApplyGit/tree/master/MultiIndicator/anim_swap.gif)


xml:
```java

        <android.support.v4.view.ViewPager
            android:id="@+id/viewPager"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />

        <com.example.indicatorlib.views.PageIndicatorView
            android:id="@+id/pageIndicatorView"
            app:piv_viewPager="@id/viewPager"//关联ViewPager
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_centerHorizontal="true"
            android:layout_marginBottom="48dp"
            attrs:piv_padding="12dp"
            attrs:piv_radius="8dp" />
```
java:
```java
        pageIndicatorView.setAnimationType(customization.getAnimationType());
        pageIndicatorView.setOrientation(customization.getOrientation());
        pageIndicatorView.setRtlMode(customization.getRtlMode());
        pageIndicatorView.setInteractiveAnimation(customization.isInteractiveAnimation());
        pageIndicatorView.setAutoVisibility(customization.isAutoVisibility());
        pageIndicatorView.setFadeOnIdle(customization.isFadeOnIdle());
```

##  通用配置：
1. project build.gradle
```java
        allprojects {
            repositories {
                maven { url 'https://jitpack.io' }
            }
        }
```
2. app build.gradle
```java
        dependencies {
                implementation 'com.github.pengMaster:MultiIndicator:0.0.1'
        }
```

##  如果存在appcompat-v7 jar包冲突：
```java
    implementation ('com.github.pengMaster:MultiIndicator:0.0.1'){
        exclude(module:'com.android.support:appcompat-v7')

    }
```
