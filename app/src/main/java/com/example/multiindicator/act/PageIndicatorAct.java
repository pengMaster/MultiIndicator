package com.example.multiindicator.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.indicatorlib.views.PageIndicatorView;
import com.example.multiindicator.R;
import com.example.multiindicator.adapter.HomeAdapter;
import com.example.multiindicator.data.Customization;

import java.util.ArrayList;
import java.util.List;



public class PageIndicatorAct extends AppCompatActivity {

    private PageIndicatorView pageIndicatorView;
    private Customization customization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_page_indicator);
        customization = new Customization();

        initViews();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        boolean customization = requestCode == CustomizeActivity.EXTRAS_CUSTOMIZATION_REQUEST_CODE && resultCode == RESULT_OK;
        if (customization && intent != null) {
            this.customization = intent.getParcelableExtra(CustomizeActivity.EXTRAS_CUSTOMIZATION);
            updateIndicator();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_customize, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionCustomize:
                CustomizeActivity.start(this, customization);
                return true;
            case android.R.id.home:
                onBackPressed();
                return super.onOptionsItemSelected(item);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressWarnings("ConstantConditions")
    private void initViews() {
        HomeAdapter adapter = new HomeAdapter();
        adapter.setData(createPageList());

        final ViewPager pager = findViewById(R.id.viewPager);
        pager.setAdapter(adapter);

        pageIndicatorView = findViewById(R.id.pageIndicatorView);
    }

    @NonNull
    private List<View> createPageList() {
        List<View> pageList = new ArrayList<>();
        pageList.add(createPageView(R.color.google_red));
        pageList.add(createPageView(R.color.google_blue));
        pageList.add(createPageView(R.color.google_yellow));
        pageList.add(createPageView(R.color.google_green));

        return pageList;
    }

    @NonNull
    private View createPageView(int color) {
        View view = new View(this);
        view.setBackgroundColor(getResources().getColor(color));

        return view;
    }

    private void updateIndicator() {
        if (customization == null) {
            return;
        }
        pageIndicatorView.setAnimationType(customization.getAnimationType());
        pageIndicatorView.setOrientation(customization.getOrientation());
        pageIndicatorView.setRtlMode(customization.getRtlMode());
        pageIndicatorView.setInteractiveAnimation(customization.isInteractiveAnimation());
        pageIndicatorView.setAutoVisibility(customization.isAutoVisibility());
        pageIndicatorView.setFadeOnIdle(customization.isFadeOnIdle());
    }

}
