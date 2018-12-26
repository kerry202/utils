package com.namele.bit.ui;

import android.widget.Button;

import com.namele.bit.R;
import com.namele.bit.base.BaseActivity;
import com.namele.bit.info.TestBean;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.disposables.CompositeDisposable;

public class CActivity extends BaseActivity {

    private static final String TAG = "BActivity";

    public CompositeDisposable compositeDisposable = new CompositeDisposable();
    @BindView(R.id.c)
    Button c;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_c;
    }
    @OnClick(R.id.c)
    public void onViewClicked() {
        EventBus.getDefault().post(new TestBean());

//        startActivity(new Intent(this,MainActivity.class));
    }
}
