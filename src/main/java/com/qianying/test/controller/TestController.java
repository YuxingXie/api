package com.qianying.test.controller;

import com.qianying.common.base.BaseRestSpringController;
import com.qianying.common.util.DateUtil;
import com.qianying.common.util.FileUtil;
import com.qianying.common.util.OuterRequestUtil;
import com.qianying.domain.user.service.impl.UserService;
import com.qianying.support.vo.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController extends BaseRestSpringController {
    private static Logger logger = LogManager.getLogger();
    protected static final String DEFAULT_SORT_COLUMNS = null;
    protected static final String REDIRECT_ACTION = "";
    @Resource(name = "userService")
    UserService userService;

    @InitBinder("productSeries")
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }




    @RequestMapping(value="/excel")
    public void batch_trans(HttpServletRequest request,HttpServletResponse response) throws IOException {
        // 定义一个list集合假数据
        List<String[]> lst = new ArrayList();

        //模拟数据
        for (int i = 0; i < 3; i++) {
            String[] strs = new String[10];
            for (int j=0;j<10;j++){
                strs[j]=i+"_"+j;
            }
            lst.add(strs);
        }
        //生成字符串
        String string="顺序号|收款户名|身份证号|手机号|收款银行|收款账号省份|收款账号地市|收款账号开户行|收款账号|收款金额\r\n";
        int lineNumber=0;
        for(String[] strings:lst){
            lineNumber++;
            String line="";
            for (String str:strings){
                if (line.length()>0)
                    line+="|"+str;
                else line+=str;
            }
            if (lst.size()!=lineNumber){
                string+=line+"\r\n";
            }else{
                string+=line;
            }

        }
        String fileDirPath="D:\\develop\\projects\\ideaProjects\\anhua-heicha\\src\\main\\webapp\\statics\\temp";
        String filePath=fileDirPath+"\\"+ DateUtil.getCurrentYMD()+".txt";
        FileUtil.writeFile(string,filePath);
        FileUtil.fileDownload(response,filePath);

//        ServiceManager.alipayTransService.updateByIds(new String[]{"5803db56d8326520d0be51e0","580499f0d832651eec42b150"},"alipayBatchTrans",alipayBatchTrans);
        return;
    }
//    @RequestMapping(value="/removeAll")
//    public void removeAll(HttpServletRequest request,HttpServletResponse response){
//        ServiceManager.alipayTransService.removeAll();
//        ServiceManager.accountService.removeAll();
//        ServiceManager.alipayBatchTransService.removeAll();
//        ServiceManager.authorizeInfoService.removeAll();
//        ServiceManager.bankService.removeAll();
//        ServiceManager.notifyService.removeAll();
//        ServiceManager.orderService.removeAll();
//        ServiceManager.userService.removeAll();
//        ServiceManager.userMeasureService.removeAll();
//        ServiceManager.userPointsService.removeAll();
//    }
    @RequestMapping(value="/weixin")
    public void weixin(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Message message=new Message();
        message.setSuccess(true);
        String ret=OuterRequestUtil.sendGet("https://api.weixin.qq.com/cgi-bin/token","grant_type=client_credential&appid=wx106549d769303d17&secret=b32f929c672fbbec7297f5cdba70c89b");
        logger.info(ret);
        message.setData(ret);
        String echostr = request.getParameter("echostr");
        PrintWriter out = response.getWriter();
        System.out.println(echostr);
        out.print(echostr);
//        return new ResponseEntity<Message>(message,HttpStatus.OK);
    }

}
