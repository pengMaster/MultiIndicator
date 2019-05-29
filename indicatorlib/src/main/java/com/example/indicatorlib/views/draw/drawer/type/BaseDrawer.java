package com.example.indicatorlib.views.draw.drawer.type;

import android.graphics.Paint;

import com.example.indicatorlib.views.draw.data.Indicator;

import android.support.annotation.NonNull;

class BaseDrawer {

    Paint paint;
    Indicator indicator;

    BaseDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        this.paint = paint;
        this.indicator = indicator;
    }
}
