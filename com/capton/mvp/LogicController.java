package com.capton.test.mvp;

/**
 * Created by capton on 2018/4/13.
 */

public interface LogicController {
    /**
     * 成功取得数据的回调方法
     * @param rawData 取得的文字内容（请自行解析json）
     * @param tag     请求标签
     */
    void dataGot(String rawData,String tag);

    /**
     * 取数据失败的回调方法
     * @param error  错误日志
     * @param tag    请求标签
     */
    void dataGoterror(String error,String tag);
}
