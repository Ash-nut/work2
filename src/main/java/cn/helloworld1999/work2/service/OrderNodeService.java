package cn.helloworld1999.work2.service;

import cn.helloworld1999.work2.bean.OrderNode;
import cn.helloworld1999.work2.bean.vo.OrderInfoVo;
import cn.helloworld1999.work2.util.ResultObj;

public interface OrderNodeService {
    ResultObj findAll(OrderInfoVo orderInfoVo);
    ResultObj updateNode(OrderNode orderNode);

}
