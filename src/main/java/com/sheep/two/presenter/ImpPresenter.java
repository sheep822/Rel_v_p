package com.sheep.two.presenter;

import com.sheep.two.base.BasePresenter;
import com.sheep.two.bean.NewsBean;
import com.sheep.two.contract.RelContract;
import com.sheep.two.model.ImpModel;
import com.sheep.two.utils.net.RelCallBack;

public class ImpPresenter extends BasePresenter<RelContract.RelModel<NewsBean>, RelContract.RelView> implements RelContract.RelPresnter {


    public ImpPresenter(RelContract.RelView view) {
        super(view);
    }

    @Override
    protected RelContract.RelModel<NewsBean> getModel() {
        return new ImpModel<NewsBean>();
    }

    @Override
    public void getData(String url) {
        model.getData(url, new RelCallBack<NewsBean>() {
            @Override
            public void onSucess(NewsBean newsBean) {
                view.onSucess(newsBean);
            }

            @Override
            public void onFail(String error) {
                view.onFail("错误" + error);
            }
        });
    }
}
