package com.example.multiindicator.act;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.multiindicator.R;
import com.example.multiindicator.data.Customization;
import com.example.multiindicator.data.CustomizationConverter;


public class CustomizeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {

    public static final String EXTRAS_CUSTOMIZATION = "EXTRAS_CUSTOMIZATION";
    public static final int EXTRAS_CUSTOMIZATION_REQUEST_CODE = 1000;

    private Customization customization;

    public static void start(@NonNull Activity activity, @NonNull Customization customization) {
        Intent intent = new Intent(activity, CustomizeActivity.class);
        intent.putExtra(EXTRAS_CUSTOMIZATION, customization);
        activity.startActivityForResult(intent, EXTRAS_CUSTOMIZATION_REQUEST_CODE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_customize);

        initData();
        initViews();
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra(EXTRAS_CUSTOMIZATION, customization);
        setResult(Activity.RESULT_OK, intent);

        super.finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spinnerAnimationType:
                customization.setAnimationType(CustomizationConverter.getAnimationType(position));
                break;

            case R.id.spinnerOrientation:
                customization.setOrientation(CustomizationConverter.getOrientation(position));
                break;

            case R.id.spinnerRtl:
                customization.setRtlMode(CustomizationConverter.getRtlMode(position));
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {/*empty*/}

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        switch (id) {
            case R.id.switchInteractiveAnimation:
                customization.setInteractiveAnimation(isChecked);
                break;

            case R.id.switchAutoVisibility:
                customization.setAutoVisibility(isChecked);
                break;

            case R.id.switchFadeOnIdle:
                customization.setFadeOnIdle(isChecked);
                break;
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            customization = intent.getParcelableExtra(EXTRAS_CUSTOMIZATION);
        } else {
            customization = new Customization();
        }
    }

    private void initViews() {
        Spinner spinnerAnimationType = findViewById(R.id.spinnerAnimationType);
        setSpinnerAdapter(spinnerAnimationType, R.array.animation_type);
        spinnerAnimationType.setOnItemSelectedListener(this);
        spinnerAnimationType.setSelection(customization.getAnimationType().ordinal());

        Spinner spinnerOrientation = findViewById(R.id.spinnerOrientation);
        setSpinnerAdapter(spinnerOrientation, R.array.orientation);
        spinnerOrientation.setOnItemSelectedListener(this);
        spinnerOrientation.setSelection(customization.getOrientation().ordinal());

        Spinner spinnerRtl = findViewById(R.id.spinnerRtl);
        setSpinnerAdapter(spinnerRtl, R.array.rtl);
        spinnerRtl.setOnItemSelectedListener(this);
        spinnerRtl.setSelection(customization.getRtlMode().ordinal());

        Switch switchInteractiveAnimation = findViewById(R.id.switchInteractiveAnimation);
        switchInteractiveAnimation.setOnCheckedChangeListener(this);
        switchInteractiveAnimation.setChecked(customization.isInteractiveAnimation());

        Switch switchAutoVisibility = findViewById(R.id.switchAutoVisibility);
        switchAutoVisibility.setOnCheckedChangeListener(this);
        switchAutoVisibility.setChecked(customization.isAutoVisibility());

        Switch switchFadeOnIdle = findViewById(R.id.switchFadeOnIdle);
        switchFadeOnIdle.setOnCheckedChangeListener(this);
        switchFadeOnIdle.setChecked(customization.isFadeOnIdle());

    }

    private void setSpinnerAdapter(@Nullable Spinner spinner, int textArrayId) {
        if (spinner != null) {
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, textArrayId, R.layout.item_spinner_selected);
            adapter.setDropDownViewResource(R.layout.item_spinner_drop_down);
            spinner.setAdapter(adapter);
            spinner.getBackground().setColorFilter(getResources().getColor(R.color.gray_500), PorterDuff.Mode.SRC_ATOP);
        }
    }
}
