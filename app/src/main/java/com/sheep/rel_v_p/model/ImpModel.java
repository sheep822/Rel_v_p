package com.sheep.rel_v_p.model;

import com.sheep.rel_v_p.contract.RelContract;
import com.sheep.rel_v_p.utils.net.RelCallBack;

public class ImpModel<T> implements RelContract.RelModel<T> {
    @Override
    public void getData(String url, RelCallBack<T> callBack) {

    }
}
