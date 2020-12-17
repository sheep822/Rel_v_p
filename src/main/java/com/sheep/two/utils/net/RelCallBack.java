package com.sheep.two.utils.net;

public interface RelCallBack<B> {
    void onSucess(B b);
    void onFail(String error);
}
