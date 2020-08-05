package com.taobao.weex.analyzer;


import androidx.annotation.NonNull;

/**
 * Description:
 * <p>
 * Created by rowandjj(chuyi)<br/>
 */

public interface IPermissionHandler {
    boolean isPermissionGranted(@NonNull Config config);
}
