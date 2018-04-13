package com.capton.test.mvp;

import android.content.Context;

import java.util.Map;

/**
 * Created by capton on 2018/4/13.
 */

public  abstract class Presenter <T extends Model> implements DataHandler{

    protected View view;
    protected T model;

    public Presenter(View view) {
        this.view = view;
        initModel();
    }

    /**
     * 子类 实现此方法，return返回一个Model的子类（实现类）对象
     * @return
     */
    protected abstract T getModel();

    private void initModel() {
        this.model = getModel();
    }

    @Override
    public void getData(Context context,Map<String, Object> paramMap,String tag) {
        model.getData(context,paramMap,tag);
    }

    @Override
    public void dataGot(String rawData,String tag) {
        view.dataGot(rawData,tag);
    }

    @Override
    public void dataGoterror(String error,String tag) {
        view.dataGoterror(error,tag);
    }
}
