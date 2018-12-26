package com.namele.bit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.namele.bit.R;
import com.namele.bit.base.BaseActivity;
import com.namele.bit.info.TestBean;
import com.namele.bit.utils.log.Logs;
import com.namele.bit.utils.log.MyEvents;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends BaseActivity {

    public CompositeDisposable compositeDisposable = new CompositeDisposable();
    private static final String TAG = "MainActivity";
    MyEvents myEvents = new MyEvents();
    @BindView(R.id.main)
    TextView main;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(TestBean event) {
        Logs.a(TAG, "MainActivity");

    }


    @OnClick(R.id.main)
    public void onViewClicked() {
        Logs.e(TAG, "onclick");
        startActivity(new Intent(this, AActivity.class));
    }

//    DisposableObserver<TestBean> observer = new DisposableObserver<TestBean>() {
//        @Override
//        protected void onStart() {
//            super.onStart();
//        }
//
//        @Override
//        public void onNext(@NonNull TestBean s) {
//
//        }
//
//        @Override
//        public void onError(@NonNull Throwable e) {
//
//        }
//
//        @Override
//        public void onComplete() {
//
//        }
//    };
//
//        compositeDisposable.add(observer);
//    Map<String, String> params = new Hashtable<>();
//
//        HttpMethods.getInstance().collectRedPackge(observer, params);


}
