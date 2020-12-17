package com.sheep.two.utils.net;

import java.util.HashMap;

public interface NetWorkInterFace {
    public <B> void get(String url, RelCallBack<B> relCallBack);

    public <B> void post(String url, RelCallBack<B> relCallBack);

    public <B> void postpar(String url, HashMap<String, String> map, RelCallBack<B> relCallBack);
}
