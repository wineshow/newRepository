package com.yqls.wanandroid.base;

import android.app.Dialog;

/**
 * @author yiqulius
 * @date 2019/8/22.
 * GitHub：https://github.com/yiqulius/WanAndroidYqls.git
 * email：2024545064@qq.com
 * description：
 */
public interface IBaseMvpView {

    Dialog getLoadDialog();

    void cancelLoadDialog();
}
