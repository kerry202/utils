package com.namele.bit.base;

import android.app.Application;
import android.content.Context;

import org.greenrobot.eventbus.EventBus;

public class NameleApp extends Application {

    private static EventBus mEventBus;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        mEventBus = EventBus.getDefault();


    }


    public static EventBus getEventBus() {

        return mEventBus;
    }
}
