package com.taobao.weex.analyzer.core.reporter;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.fastjson.JSON;
import com.taobao.weex.analyzer.core.Constants;
import com.taobao.weex.analyzer.core.reporter.ws.IWebSocketBridge;
import com.taobao.weex.analyzer.core.reporter.ws.WebSocketClient;
import com.taobao.weex.analyzer.core.reporter.ws.WebSocketClientFactory;

import org.apache.weex.utils.WXLogUtils;

/**
 * Description:
 * <p>
 * Created by rowandjj(chuyi)<br/>
 */

class WebSocketReporter implements IDataReporter {
    private boolean isEnabled;

    @Nullable
    private WebSocketClient mSocketClient = null;

    WebSocketReporter(boolean enabled, IWebSocketBridge bridge) {
        this.isEnabled = enabled;
        mSocketClient = WebSocketClientFactory.create(bridge);
    }

    @Override
    public void report(@NonNull ProcessedData data) {
        if (mSocketClient != null && mSocketClient.isOpen()) {
            mSocketClient.sendText(JSON.toJSONString(data));
        }
        //SHOULD REMOVED LATER
        WXLogUtils.d(Constants.TAG, JSON.toJSONString(data));
    }

    public void connect(String url, WebSocketClient.Callback callback) {
        if (mSocketClient != null) {
            mSocketClient.connect(url, callback);
        }
    }

    public void close(int closeReason, String reasonPhrase) {
        if (mSocketClient != null && mSocketClient.isOpen()) {
            mSocketClient.close(closeReason, reasonPhrase);
        }
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
