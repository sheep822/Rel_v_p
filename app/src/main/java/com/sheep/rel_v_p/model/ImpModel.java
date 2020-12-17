package com.sheep.rel_v_p.model;

import com.sheep.rel_v_p.contract.RelContract;
import com.sheep.rel_v_p.utils.net.RelCallBack;
import com.sheep.rel_v_p.utils.net.RetrofitUtils;

public class ImpModel<T> implements RelContract.RelModel<T> {
    @Override
    public void getData(String url, RelCallBack<T> callBack) {
        RetrofitUtils instance = RetrofitUtils.getInstance();
        instance.get(url,callBack);
    }
}
