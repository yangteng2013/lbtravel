package com.lymobility.traningjetpack.dicos;

import android.util.Log;

public class NetworkClient {
    String baseUrl;

    public NetworkClient() {
        this.baseUrl = "https://cxymm.net/article/weixin_44941011/90047280";
    }

    public NetworkClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void init(){
        Log.d("NetworkClient","网络初始化...");
    }
}
