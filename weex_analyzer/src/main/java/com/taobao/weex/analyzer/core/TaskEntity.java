package com.taobao.weex.analyzer.core;

import android.support.annotation.NonNull;

/**
 * Description:
 * <p>
 * Created by rowandjj(chuyi)<br/>
 */

public interface TaskEntity<T> {

    void onTaskInit();

    @NonNull
    T onTaskRun();

    void onTaskStop();
}
