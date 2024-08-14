package cn.helloworld1999.work2.service.impl;

import cn.helloworld1999.work2.bean.OrderNode;
import cn.helloworld1999.work2.bean.SysRole;
import cn.helloworld1999.work2.bean.SysUser;
import cn.helloworld1999.work2.bean.vo.OrderInfoVo;
import cn.helloworld1999.work2.bean.vo.OrderNodeVo;
import cn.helloworld1999.work2.mapper.OrderNodeMapper;
import cn.helloworld1999.work2.service.OrderNodeService;
import cn.helloworld1999.work2.util.ResultObj;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderNodeServiceImpl implements OrderNodeService {
    @Resource
    private OrderNodeMapper orderNodeMapper;
    @Override
    public ResultObj findAll(HttpSession session,OrderNodeVo orderNodeVo) {
        SysUser sysUser = (SysUser) session.getAttribute("user");
        SysRole sysRole = (SysRole) session.getAttribute("sysRole");
        Page<OrderNode> page = new Page<>(orderNodeVo.getCurrentPage(),orderNodeVo.getPageSize());
        LambdaQueryWrapper<OrderNode> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 如果不是管理员的话，那就只能搜到自己的待办
        if (sysRole.getRole().equals("超级管理员")){
            lambdaQueryWrapper.eq(orderNodeVo.getId() != null,OrderNode::getId,orderNodeVo.getId())
                    .like(orderNodeVo.getOId() != null,OrderNode::getOId,orderNodeVo.getOId())
                    .like(orderNodeVo.getOrderOfApproval() != null,OrderNode::getOrderOfApproval,orderNodeVo.getOrderOfApproval())
                    .like(orderNodeVo.getUId() != null,OrderNode::getUId,orderNodeVo.getUId())
                    .like(orderNodeVo.getUpdateTime() != null,OrderNode::getUpdateTime,orderNodeVo.getUpdateTime())
                    .like(orderNodeVo.getResultOfHandling() != null,OrderNode::getResultOfHandling,orderNodeVo.getResultOfHandling())
                    .like(orderNodeVo.getRemark() != null,OrderNode::getRemark,orderNodeVo.getRemark());
        }else {
            lambdaQueryWrapper.eq(orderNodeVo.getId() != null,OrderNode::getId,orderNodeVo.getId())
                    .like(orderNodeVo.getOId() != null,OrderNode::getOId,orderNodeVo.getOId())
                    .like(orderNodeVo.getOrderOfApproval() != null,OrderNode::getOrderOfApproval,orderNodeVo.getOrderOfApproval())
                    .like(orderNodeVo.getUId() != null,OrderNode::getUId,sysUser.getId())
                    .like(orderNodeVo.getUpdateTime() != null,OrderNode::getUpdateTime,orderNodeVo.getUpdateTime())
                    .like(orderNodeVo.getResultOfHandling() != null,OrderNode::getResultOfHandling,orderNodeVo.getResultOfHandling())
                    .like(orderNodeVo.getRemark() != null,OrderNode::getRemark,orderNodeVo.getRemark());
        }
        return ResultObj.ok().data(orderNodeMapper.selectPage(page,lambdaQueryWrapper));
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

    @Override
    public ResultObj createNodeByNodeList(List<OrderNode> orderNodeList) {
        int i=0;
        for (OrderNode orderNode : orderNodeList) {
            if (orderNodeMapper.insert(orderNode)==1){
                i++;
            }
        }
        if (i==orderNodeList.size()){
            return ResultObj.ok();
        }
        return ResultObj.error();
    }
}
