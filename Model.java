package com.capton.test.mvp;

import android.content.Context;

import java.util.Map;

/**
 * Created by capton on 2018/4/13.
 */

public abstract class Model implements DataHandler{

    public Presenter presenter;

    public Model(Presenter presenter) {
        this.presenter = presenter;
    }

    /**
     * 在子类实现此方法， 成功取得数据后调用 dataGot(String rawData); 请求失败调用 dataGoterror(String error)
     * @param context  上下文对象
     * @param paramMap  参数Map,传入前确保已设置了，例如最重要的地址,post参数，headers等参数
     * @param tag  请求标签，用于区别不同的请求
     */
    @Override
    public abstract void getData(Context context,Map<String, Object> paramMap,String tag);

    @Override
    public  void dataGot(String rawData,String tag){
        presenter.dataGot(rawData,tag);
    }

    @Override
    public void dataGoterror(String error,String tag) {
        presenter.dataGoterror(error,tag);
    }
}
