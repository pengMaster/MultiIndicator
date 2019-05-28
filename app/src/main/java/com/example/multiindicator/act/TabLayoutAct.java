package com.example.multiindicator.act;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.indicatorlib.base.BaseFragmentAdapter;
import com.example.indicatorlib.views.TabLayout;
import com.example.multiindicator.R;
import com.example.multiindicator.frag.TestFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : Wp
 *     e-mail : 1101313414@qq.com
 *     time   : 2019/5/28 6:29 PM
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class TabLayoutAct extends AppCompatActivity {

    private ViewPager mViewPager;

    private TabLayout mTopTabLayout;
    private TabLayout mCenterTabLayout;
    private TabLayout mBottomTabLayout;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tab_layout);
        initUI();
        setUI();
    }

    private void initUI() {
        mViewPager = findViewById(R.id.vp);
        mTopTabLayout = findViewById(R.id.nts_top);
        mCenterTabLayout = findViewById(R.id.nts_center);
        mBottomTabLayout = findViewById(R.id.nts_bottom);
    }

    private void setUI() {
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
        mTopTabLayout.setViewPager(mViewPager, 1);
        mBottomTabLayout.setViewPager(mViewPager, 1);

//        mTabLayout.setTitles("Tab1", "Tab2", "Tab3");
//        mTabLayout.setTabIndex(0, true);
//        mTabLayout.setTitleSize(15);
//        mTabLayout.setStripColor(Color.RED);
//        mTabLayout.setStripWeight(6);
//        mTabLayout.setStripFactor(2);
//        mTabLayout.setStripType(TabLayout.StripType.LINE);
//        mTabLayout.setStripGravity(TabLayout.StripGravity.BOTTOM);
//        mTabLayout.setTypeface("fonts/typeface.ttf");
//        mTabLayout.setCornersRadius(3);
//        mTabLayout.setAnimationDuration(300);
//        mTabLayout.setInactiveColor(Color.GRAY);
//        mTabLayout.setActiveColor(Color.WHITE);
//        mTabLayout.setOnPageChangeListener(...);
//        mTabLayout.setOnTabStripSelectedIndexListener(...);
    }
}
