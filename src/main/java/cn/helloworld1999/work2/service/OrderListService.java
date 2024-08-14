package cn.helloworld1999.work2.service;

import cn.helloworld1999.work2.bean.vo.OrderInfoVo;
import cn.helloworld1999.work2.util.ResultObj;
import jakarta.servlet.http.HttpSession;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface OrderListService {
    ResultObj findAll(HttpSession session, OrderInfoVo orderInfoVo);
    ResultObj createOrder(HttpSession session,OrderInfoVo orderInfoVo);
    // 创建一个 带 审批节点 的 审批单
    ResultObj createOrderAndNodes(HttpSession session,OrderInfoVo orderInfoVo);
}
