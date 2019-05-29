package com.example.indicatorlib.views.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.indicatorlib.views.animation.data.Value;
import com.example.indicatorlib.views.animation.data.type.DropAnimationValue;
import com.example.indicatorlib.views.draw.data.Indicator;
import com.example.indicatorlib.views.draw.data.Orientation;

import android.support.annotation.NonNull;

public class DropDrawer extends BaseDrawer {

    public DropDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        super(paint, indicator);
    }

    public void draw(
            @NonNull Canvas canvas,
            @NonNull Value value,
            int coordinateX,
            int coordinateY) {

        if (!(value instanceof DropAnimationValue)) {
            return;
        }

        DropAnimationValue v = (DropAnimationValue) value;
        int unselectedColor = indicator.getUnselectedColor();
        int selectedColor = indicator.getSelectedColor();
        float radius = indicator.getRadius();

        paint.setColor(unselectedColor);
        canvas.drawCircle(coordinateX, coordinateY, radius, paint);

        paint.setColor(selectedColor);
        if (indicator.getOrientation() == Orientation.HORIZONTAL) {
            canvas.drawCircle(v.getWidth(), v.getHeight(), v.getRadius(), paint);
        } else {
            canvas.drawCircle(v.getHeight(), v.getWidth(), v.getRadius(), paint);
        }
    }
}
