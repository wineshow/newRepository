package com.yqls.wanandroid.base;

import android.os.Bundle;

/**
 * @author yiqulius
 * @date 2019/8/22.
 * GitHub：https://github.com/yiqulius/WanAndroidYqls.git
 * email：2024545064@qq.com
 * description：
 */
public interface IActivity {

    int getLayout();

    void initView();

    void initData(Bundle saveInstanceStatus);
}
