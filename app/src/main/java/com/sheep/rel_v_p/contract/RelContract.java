package com.sheep.rel_v_p.contract;

import com.sheep.rel_v_p.utils.net.RelCallBack;

public class RelContract {
    public interface RelModel<B>{
        void getData(String url, RelCallBack<B> callBack);
    }

    public interface RelPresenter{
        void getData(String url);
    }

    public interface RelView<T>{
        void onSucess(T t);
        void onFail(String error);
    }
}
































