package cn.helloworld1999.work2.service;

import cn.helloworld1999.work2.bean.vo.OrderInfoVo;
import cn.helloworld1999.work2.util.ResultObj;
import jakarta.servlet.http.HttpSession;

public interface OrderListService {
    ResultObj findAll(HttpSession session, OrderInfoVo orderInfoVo);

}
