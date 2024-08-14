package cn.helloworld1999.work2.service.impl;

import cn.helloworld1999.work2.bean.OrderNode;
import cn.helloworld1999.work2.bean.vo.OrderInfoVo;
import cn.helloworld1999.work2.mapper.OrderNodeMapper;
import cn.helloworld1999.work2.service.OrderNodeService;
import cn.helloworld1999.work2.util.ResultObj;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrderNodeServiceImpl implements OrderNodeService {
    @Resource
    private OrderNodeMapper orderNodeMapper;
    @Override
    public ResultObj findAll(OrderInfoVo orderInfoVo) {

        return null;
    }

    @Override
    public ResultObj findNodeOfOrder(OrderInfoVo orderInfoVo) {
        LambdaQueryWrapper<OrderNode> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(OrderNode::getOId,orderInfoVo.getId());
        return ResultObj.ok().data(orderNodeMapper.selectList(lambdaQueryWrapper));
    }

    @Override
    public ResultObj updateNode(OrderNode orderNode) {
        return null;
    }
}
