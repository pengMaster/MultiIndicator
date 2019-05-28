package com.example.multiindicator.act;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.multiindicator.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onTabViewClick(View view) {
        startActivity(new Intent(getApplicationContext(),TabViewAct.class));
    }

    public void onTabLayoutClick(View view) {
        startActivity(new Intent(getApplicationContext(),TabLayoutAct.class));
    }
}
