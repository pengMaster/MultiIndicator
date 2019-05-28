package com.example.multiindicator.act;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.indicatorlib.base.BaseFragmentAdapter;
import com.example.indicatorlib.views.TabView;
import com.example.multiindicator.R;
import com.example.multiindicator.frag.TestFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : Wp
 *     e-mail : 1101313414@qq.com
 *     time   : 2019/5/28 4:01 PM
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class TabViewAct extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tab_view);
        initViewPager();
    }

    private void initViewPager() {
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
    }
}
