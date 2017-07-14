package com.qianying.support.callBack;

import com.qianying.support.vo.Message;

import java.util.Map;

/**
 * Created by Administrator on 2016/9/7.
 */
public interface CallBackInterface {
    Map<String, Object> getReturnValueMap();

    Message getMessage();

    boolean isSuccess();
}
