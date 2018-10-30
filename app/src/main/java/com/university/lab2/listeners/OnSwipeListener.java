package com.university.lab2.listeners;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public abstract class OnSwipeListener implements View.OnTouchListener {
    private GestureDetector gestureDetector;

    public OnSwipeListener(Context context) {
        gestureDetector = new GestureDetector(context, new GestureListener() {
            @Override
            protected void onSwipeTop() {
                OnSwipeListener.this.onSwipeTop();
            }

            @Override
            protected void onSwipeBottom() {
                OnSwipeListener.this.onSwipeBottom();
            }

            @Override
            protected void onSwipeLeft() {
                OnSwipeListener.this.onSwipeLeft();
            }

            @Override
            protected void onSwipeRight() {
                OnSwipeListener.this.onSwipeRight();
            }
        });
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    public abstract void onSwipeRight();

    public abstract void onSwipeLeft();

    public abstract void onSwipeTop();

    public abstract void onSwipeBottom();

}
