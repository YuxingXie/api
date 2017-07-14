package com.qianying.common.helper.service;

import com.qianying.domain.user.service.IUserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class ServiceManager implements InitializingBean {

    private static boolean inited;

    public static IUserService userService;

    public static void setInited(boolean inited) {
        ServiceManager.inited = inited;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        inited = true;
    }

    public void setUserService(IUserService userService) {
        ServiceManager.userService = userService;
    }

}
