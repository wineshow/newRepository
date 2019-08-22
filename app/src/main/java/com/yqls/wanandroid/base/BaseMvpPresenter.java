package com.yqls.wanandroid.base;

import java.lang.ref.WeakReference;

/**
 * @author yiqulius
 * @date 2019/8/22.
 * GitHub：https://github.com/yiqulius/WanAndroidYqls.git
 * email：2024545064@qq.com
 * description：
 */
class BaseMvpPresenter<V> {

    /**
     * v层泛型引用
     */
    protected V mView;

    private WeakReference<V> weakReferenceView;

    protected V getView(){
        if (mView == null){
            throw new IllegalStateException("view not attached");
        } else {
            return mView;
        }
    }

    public void attachMvpView(V view){
        if (view != null){
            weakReferenceView = new WeakReference<>(view);
            this.mView = weakReferenceView.get();
        }
    }

    public void detachMvpView(){
        weakReferenceView.clear();
        weakReferenceView = null;
        mView = null;
    }
}
