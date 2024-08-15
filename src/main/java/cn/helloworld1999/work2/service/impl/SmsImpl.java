package cn.helloworld1999.work2.service.impl;

import cn.helloworld1999.work2.service.SMS;
import cn.helloworld1999.work2.util.ResultObj;
import cn.helloworld1999.work2.util.getSMS;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class SmsImpl implements SMS {
    @Override
    public ResultObj sendSMS(HttpSession session, String phone) throws Exception {
        String smsCode = getSMS.getSMS(phone);
        String[] sms = {smsCode, phone};
        if (!smsCode.equals("F")) {
            session.setAttribute("sms", sms);
            return ResultObj.ok();
        }
        return ResultObj.error();
    }

    @Override
    public ResultObj checkSMS(HttpSession session,String code) {
        if (session.getAttribute("sms") != null) {
            String[] sms = (String[]) session.getAttribute("sms");
            if (sms[0].equals(code)) {
                return ResultObj.ok();
            }
        }
        return ResultObj.error();
    }
}
