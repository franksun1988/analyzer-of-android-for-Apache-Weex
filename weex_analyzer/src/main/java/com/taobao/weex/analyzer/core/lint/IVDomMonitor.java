package com.taobao.weex.analyzer.core.lint;

import android.support.annotation.NonNull;

import org.apache.weex.WXSDKInstance;

/**
 * Description:
 * <p>
 * Created by rowandjj(chuyi)<br/>
 */

public interface IVDomMonitor {
    void monitor(@NonNull final WXSDKInstance instance);

    void destroy();
}
