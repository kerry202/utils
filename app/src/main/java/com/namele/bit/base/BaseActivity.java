package com.namele.bit.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.namele.bit.utils.log.MyEvents;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    public EventBus eventBus = NameleApp.getEventBus();
    public Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);

        eventBus.register(this);

        initView();

        initDate();

    }

    protected abstract int getLayoutId();

    protected void initView() {

    }

    @Subscribe
    public void onEvent(MyEvents event) {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    protected void initDate() {

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unbinder.unbind();
        eventBus.unregister(this);
    }


}
