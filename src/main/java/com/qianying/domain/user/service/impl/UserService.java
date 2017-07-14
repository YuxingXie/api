package com.qianying.domain.user.service.impl;

import com.qianying.common.base.BaseEntityManager;
import com.qianying.common.base.EntityDao;
import com.qianying.domain.user.dao.UserDao;
import com.qianying.domain.user.service.IUserService;
import com.qianying.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2015/11/6.
 */
@Service
public class UserService extends BaseEntityManager<User> implements IUserService {
    @Resource
    private UserDao userDao;

    public User findByEmailOrPhone(String emailOrPhone) {
        return userDao.findByEmailOrPhone(emailOrPhone);
    }


    @Override
    protected EntityDao<User> getEntityDao() {
        return userDao;
    }
}
