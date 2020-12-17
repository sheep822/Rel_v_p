package com.sheep.rel_v_p.presenter;

import com.sheep.rel_v_p.base.BasePresenter;
import com.sheep.rel_v_p.bean.NewsBean;
import com.sheep.rel_v_p.contract.RelContract;
import com.sheep.rel_v_p.model.ImpModel;
import com.sheep.rel_v_p.utils.net.RelCallBack;

public class ImpPresenter extends BasePresenter<RelContract.RelModel<NewsBean>, RelContract.RelView> implements RelContract.RelPresenter {


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
