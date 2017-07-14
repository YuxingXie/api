package com.qianying.domain.user.controller;

import com.qianying.common.base.BaseRestSpringController;
import com.qianying.common.constant.Constant;
import com.qianying.common.web.CookieTool;
import com.qianying.domain.user.service.impl.UserService;
import com.qianying.entity.User;
import com.qianying.support.vo.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController extends BaseRestSpringController {
    private static Logger logger = LogManager.getLogger();
    protected static final String DEFAULT_SORT_COLUMNS = null;
    protected static final String REDIRECT_ACTION = "";

    @Resource(name = "userService")
    UserService userService;

    @InitBinder("productSeries")
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @RequestMapping(value = "/logout")
    public ResponseEntity<Message> logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Message message = new Message();
        session.setAttribute(Constant.LOGIN_USER, null);
        session.removeAttribute(Constant.LOGIN_USER);
        CookieTool.removeCookie(request, response, "loginStr");
        CookieTool.removeCookie(request, response, "password");
        message.setSuccess(true);
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/one/{id}")
    public User findOne(@PathVariable String id, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        User user = new User();
        user.setId(id);
        user.setAddresses(new String[]{"aaa", "bbb"});
        user.setEmail("185246042@qq.com");
//        return userService.findById(id);
        return user;
    }

}
