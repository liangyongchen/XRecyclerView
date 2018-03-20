package com.jcodecraeer.xrecyclerview;

import android.support.design.widget.AppBarLayout;

/**
 * Created by jianghejie on 16/6/19.
 */

public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {
// 在AppBarLayout的布局偏移量发生改变时被调用。这个方法允许子view根据偏移量实现自定义的行为（比如在特定Y值的时候固定住一个View）。

    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    private State mCurrentState = State.IDLE;

    @Override
    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (i == 0) {
            if (mCurrentState != State.EXPANDED) {
                onStateChanged(appBarLayout, State.EXPANDED);
            }
            mCurrentState = State.EXPANDED;
        } else if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
            if (mCurrentState != State.COLLAPSED) {
                onStateChanged(appBarLayout, State.COLLAPSED);
            }
            mCurrentState = State.COLLAPSED;
        } else {
            if (mCurrentState != State.IDLE) {
                onStateChanged(appBarLayout, State.IDLE);
            }
            mCurrentState = State.IDLE;
        }
    }
    public abstract void onStateChanged(AppBarLayout appBarLayout, State state);
}

