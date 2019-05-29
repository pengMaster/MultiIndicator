package com.example.indicatorlib.views.animation;

import com.example.indicatorlib.views.animation.controller.AnimationController;
import com.example.indicatorlib.views.animation.controller.ValueController;
import com.example.indicatorlib.views.draw.data.Indicator;

import android.support.annotation.NonNull;

public class AnimationManager {

    private AnimationController animationController;

    public AnimationManager(@NonNull Indicator indicator, @NonNull ValueController.UpdateListener listener) {
        this.animationController = new AnimationController(indicator, listener);
    }

    public void basic() {
        if (animationController != null) {
            animationController.end();
            animationController.basic();
        }
    }

    public void interactive(float progress) {
        if (animationController != null) {
            animationController.interactive(progress);
        }
    }

    public void end() {
        if (animationController != null) {
            animationController.end();
        }
    }
}
