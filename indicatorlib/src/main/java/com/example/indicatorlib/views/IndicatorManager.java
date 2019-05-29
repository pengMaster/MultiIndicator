package com.example.indicatorlib.views;

import android.support.annotation.Nullable;

import com.example.indicatorlib.views.animation.AnimationManager;
import com.example.indicatorlib.views.animation.controller.ValueController;
import com.example.indicatorlib.views.animation.data.Value;
import com.example.indicatorlib.views.draw.DrawManager;
import com.example.indicatorlib.views.draw.data.Indicator;


public class IndicatorManager implements ValueController.UpdateListener {

    private DrawManager drawManager;
    private AnimationManager animationManager;
    private Listener listener;

    interface Listener {
        void onIndicatorUpdated();
    }

    IndicatorManager(@Nullable Listener listener) {
        this.listener = listener;
        this.drawManager = new DrawManager();
        this.animationManager = new AnimationManager(drawManager.indicator(), this);
    }

    public AnimationManager animate() {
        return animationManager;
    }

    public Indicator indicator() {
        return drawManager.indicator();
    }

    public DrawManager drawer() {
        return drawManager;
    }

    @Override
    public void onValueUpdated(@Nullable Value value) {
        drawManager.updateValue(value);
        if (listener != null) {
            listener.onIndicatorUpdated();
        }
    }
}
