package com.sheep.two.model;

import com.sheep.two.contract.RelContract;
import com.sheep.two.utils.net.RelCallBack;
import com.sheep.two.utils.net.RetrofitUtils;

public class ImpModel<T> implements RelContract.RelModel<T> {

    private RetrofitUtils instance;

    @Override
    public void getData(String url, RelCallBack<T> callBack) {
        instance = RetrofitUtils.getInstance();
        instance.get(url,callBack);
    }
}
