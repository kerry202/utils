package com.namele.bit.https.subscribers;

/**
 * Created by yangbo on 2018/2/10
 */

public interface SubscriberOnNextListener<T> {
    void onNext(T t);
}
