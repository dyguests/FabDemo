package com.fanhl.fabdemo;

import android.support.annotation.DrawableRes;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;

/**
 * Created by fanhl on 2017/4/15.
 */

public class AnimateUtil {
    public static void changeFab(final FloatingActionButton fab, @DrawableRes final int resId) {
        fab.post(new Runnable() {
            @Override
            public void run() {
                fab.clearAnimation();
                // Scale down animation
                ScaleAnimation shrink = new ScaleAnimation(1f, 0.2f, 1f, 0.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                shrink.setDuration(150);     // animation duration in milliseconds
                shrink.setInterpolator(new DecelerateInterpolator());
                shrink.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
//                fab.setBackgroundTintList(getResources().getColorStateList(colorIntArray[position]));
                        fab.setImageResource(resId);

                        // Scale up animation
                        ScaleAnimation expand = new ScaleAnimation(0.2f, 1f, 0.2f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                        expand.setDuration(150);     // animation duration in milliseconds
                        expand.setInterpolator(new AccelerateInterpolator());
                        fab.startAnimation(expand);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                fab.startAnimation(shrink);
            }
        });
    }

    public static void changeView(final View view1, final View view2) {
        view1.post(new Runnable() {
            @Override
            public void run() {
                view1.clearAnimation();
                view2.clearAnimation();

                AlphaAnimation fade = new AlphaAnimation(1f, .2f);
                fade.setDuration(150);     // animation duration in milliseconds
                fade.setInterpolator(new DecelerateInterpolator());
                fade.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        view1.setVisibility(View.VISIBLE);
                        view2.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view1.setVisibility(View.INVISIBLE);
                        view2.setVisibility(View.VISIBLE);

                        AlphaAnimation deepen = new AlphaAnimation(.2f, 1f);
                        deepen.setDuration(150);     // animation duration in milliseconds
                        deepen.setInterpolator(new AccelerateInterpolator());
                        view2.startAnimation(deepen);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                view1.startAnimation(fade);
            }
        });
    }

    public static void showFab(final FloatingActionButton fab) {
        fab.post(new Runnable() {
            @Override
            public void run() {
                fab.clearAnimation();
                // Scale down animation
                ScaleAnimation shrink = new ScaleAnimation(.2f, 1f, .2f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                shrink.setDuration(150);     // animation duration in milliseconds
                shrink.setInterpolator(new DecelerateInterpolator());
                shrink.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        fab.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                fab.startAnimation(shrink);
            }
        });
    }

    public static void hideFab(final FloatingActionButton fab) {
        fab.post(new Runnable() {
            @Override
            public void run() {
                fab.clearAnimation();
                // Scale down animation
                ScaleAnimation shrink = new ScaleAnimation(1f, 0.2f, 1f, 0.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                shrink.setDuration(150);     // animation duration in milliseconds
                shrink.setInterpolator(new DecelerateInterpolator());
                shrink.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        fab.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        fab.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                fab.startAnimation(shrink);
            }
        });
    }
}
