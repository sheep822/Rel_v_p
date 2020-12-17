package com.sheep.rel_v_p.utils.net;

public interface RelCallBack<B> {
    void onSucess(B b);
    void onFail(String error);
}
