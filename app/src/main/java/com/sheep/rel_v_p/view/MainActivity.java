package com.sheep.rel_v_p.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sheep.rel_v_p.R;
import com.sheep.rel_v_p.adapter.RelAdapter;
import com.sheep.rel_v_p.base.BaseActivity;
import com.sheep.rel_v_p.bean.NewsBean;
import com.sheep.rel_v_p.contract.RelContract;
import com.sheep.rel_v_p.presenter.ImpPresenter;
import com.sheep.rel_v_p.utils.net.URLConstant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ImpPresenter> implements RelContract.RelView<NewsBean> {


    private RecyclerView rel;
    private ArrayList<NewsBean.NewsDTO> list;
    private RelAdapter relAdapter;

    @Override
    protected void initData() {
        presenter.getData(URLConstant.NEWSLIST);
    }

    @Override
    protected void initView() {
        rel = findViewById(R.id.rel);
        rel.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        relAdapter = new RelAdapter(list, this);
        rel.setAdapter(relAdapter);
    }

    @Override
    protected ImpPresenter getPresenter() {
        return new ImpPresenter(this);
    }

    @Override
    protected int getContenrById() {
        return R.layout.activity_main;
    }

    @Override
    public void onSucess(NewsBean newsBean) {
        List<NewsBean.NewsDTO> news = newsBean.getNews();
        list.addAll(news);
        relAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {
        Log.e("tag","错误："+error);
    }
}