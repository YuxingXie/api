package com.qianying.domain.user.service;

import com.qianying.common.base.IBaseEntityManager;
import com.qianying.entity.User;


/**
 * Created by Administrator on 2015/11/6.
 */
public interface IUserService extends IBaseEntityManager<User> {
    User findByEmailOrPhone(String name);
}
