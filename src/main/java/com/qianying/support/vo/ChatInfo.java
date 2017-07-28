package com.qianying.support.vo;

import com.qianying.entity.User;

/**
 * Created by xieyuxing on 2017/7/28.
 */
public class ChatInfo {
    private String message;
    private User user;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
