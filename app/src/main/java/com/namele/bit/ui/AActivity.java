package com.namele.bit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.namele.bit.R;
import com.namele.bit.base.BaseActivity;
import com.namele.bit.https.HttpMethods;
import com.namele.bit.info.TestBean;
import com.namele.bit.utils.log.Logs;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Hashtable;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public class AActivity extends BaseActivity {

    private static final String TAG = "AActivity";
    public CompositeDisposable compositeDisposable = new CompositeDisposable();
    @BindView(R.id.a)
    Button a;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_a;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(TestBean event) {
        Logs.a(TAG,"AAAAAAA");

    }
    @OnClick(R.id.a)
    public void onViewClicked() {
        startActivity(new Intent(this,BActivity.class));
    }
}
