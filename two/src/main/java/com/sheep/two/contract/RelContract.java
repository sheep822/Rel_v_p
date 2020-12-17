package com.sheep.two.contract;

import com.sheep.two.utils.net.RelCallBack;

public class RelContract {
    public interface RelModel<B>{
        void getData(String url, RelCallBack<B> callBack);
    }

    public interface RelView<T>{
        void  onSucess(T t);
        void onFail(String error);
    }

    public interface RelPresnter{
        void getData(String url);
    }
}
