package com.capton.test.mvp;

import android.content.Context;

import java.util.Map;

/**
 * Created by capton on 2018/4/13.
 */

public interface DataHandler extends LogicController {
    /**
     * 请看 实现类中 对本方法的具体实现
     * @param context  上下文对象
     * @param paramMap  参数Map,传入前确保已设置了，例如最重要的地址,post参数，headers等参数
     * @param tag  请求标签，用于区别不同的请求
     */
    void getData(Context context,Map<String, Object> paramMap,String tag);
}
