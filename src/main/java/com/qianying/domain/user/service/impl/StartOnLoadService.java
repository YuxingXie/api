package com.qianying.domain.user.service.impl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class StartOnLoadService {
    private static Logger logger = LogManager.getLogger();

    /**
     * Spring 容器初始化时加载
     */
    public void loadData() throws IOException {

    }


}