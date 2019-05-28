package com.example.multiindicator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

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
        Fragment fragment1 = new Fragment();
        Fragment fragment2 = new Fragment();

        BaseF
    }
}
