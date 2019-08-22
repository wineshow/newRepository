package com.yqls.wanandroid.base;

import android.app.Dialog;
import android.os.Bundle;

import com.gyf.immersionbar.ImmersionBar;
import com.squareup.leakcanary.RefWatcher;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * @author yiqulius
 * @date 2019/8/22.
 * GitHub：https://github.com/yiqulius/WanAndroidYqls.git
 * email：2024545064@qq.com
 * description：
 */
public abstract class BaseMvpActivity<V extends IBaseMvpView, P extends BaseMvpPresenter>
        extends RxAppCompatActivity implements IBaseMvpView, IActivity {

    protected P mPresenter;

    protected Dialog dialog;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayout());
        ImmersionBar.with(this).init();
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        mPresenter.attachMvpView((V) this);
        initImmersionBar();
        // add dialog
        initView();
        initData(savedInstanceState);
    }

    private void initImmersionBar() {
        ImmersionBar.with(this).init();
    }

    protected abstract P createPresenter();

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        内存泄漏
        if (mPresenter != null) {
            mPresenter.detachMvpView();
        }
    }
}
