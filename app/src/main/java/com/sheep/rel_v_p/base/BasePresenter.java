package com.sheep.rel_v_p.base;

public abstract class BasePresenter<M,V> {
    protected M model;
    protected V view;

    public BasePresenter(V view) {
        this.view = view;
        model=getModel();
    }

    protected abstract M getModel();
}

