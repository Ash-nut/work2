package cn.helloworld1999.work2.service;

import cn.helloworld1999.work2.bean.OrderNode;
import cn.helloworld1999.work2.bean.vo.OrderInfoVo;
import cn.helloworld1999.work2.util.ResultObj;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface OrderNodeService {
    // 这个函数是用来查待办、已办之类的
    ResultObj findAll(OrderInfoVo orderInfoVo);
    ResultObj findNodeOfOrder(OrderInfoVo orderInfoVo);
    ResultObj updateNode(OrderNode orderNode);
    ResultObj createNodeByNodeList(List<OrderNode> orderNodeList);
}
