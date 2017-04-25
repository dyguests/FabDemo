package com.fanhl.fabdemo;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fanhl on 2017/4/25.
 */
public class ViewUtil {
    private static boolean isViewVisible(View child, ViewGroup parent) {
        Rect scrollBounds = new Rect();
        parent.getDrawingRect(scrollBounds);
        float top = child.getY();
        float bottom = top + child.getHeight();
        if (scrollBounds.top < top && scrollBounds.bottom > bottom) {
            return true; //View is visible.
        } else {
            return false; //View is NOT visible.
        }
    }

    static boolean isViewHigher(View child, ViewGroup parent) {
        Rect scrollBounds = new Rect();
        parent.getDrawingRect(scrollBounds);
        float top = child.getY();
        float bottom = top + child.getHeight();
        if (/*scrollBounds.top < top &&*/ scrollBounds.bottom > bottom) {
            return true; //View is visible.
        } else {
            return false; //View is NOT visible.
        }
    }
}
