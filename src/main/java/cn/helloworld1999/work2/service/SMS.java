package cn.helloworld1999.work2.service;

import cn.helloworld1999.work2.util.ResultObj;
import jakarta.servlet.http.HttpSession;

public interface SMS {
    ResultObj sendSMS(HttpSession session, String phone) throws Exception;
    ResultObj checkSMS(HttpSession session,String code);
}
