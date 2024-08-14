package cn.helloworld1999.work2.service.impl;

import cn.helloworld1999.work2.bean.OrderInfo;
import cn.helloworld1999.work2.bean.SysRole;
import cn.helloworld1999.work2.bean.SysUser;
import cn.helloworld1999.work2.bean.vo.OrderInfoVo;
import cn.helloworld1999.work2.mapper.OrderListMapper;
import cn.helloworld1999.work2.service.OrderListService;
import cn.helloworld1999.work2.util.ResultObj;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderListServiceImpl implements OrderListService {
    @Resource
    private OrderListMapper orderListMapper;
    @Override
    public ResultObj findAll(HttpSession session, OrderInfoVo orderInfoVo) {
        Page<OrderInfo> page = Page.of(orderInfoVo.getCurrentPage(), orderInfoVo.getPageSize());

        SysUser sysUser = (SysUser) session.getAttribute("user");
        SysRole sysRole = (SysRole) session.getAttribute("role");
        boolean isAdmin = sysRole.getRole().equals("超级管理员");
        LambdaQueryWrapper<OrderInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 先写登录角色是管理员的情况，先查询所有
        List<OrderInfo> orderInfoList = null;
        if (isAdmin) {
            lambdaQueryWrapper.eq(orderInfoVo.getId() !=null, OrderInfo::getId, orderInfoVo.getId())
                    .eq(orderInfoVo.getDId() != null, OrderInfo::getDId, orderInfoVo.getDId())
                    .eq(orderInfoVo.getCreateUid() != null, OrderInfo::getCreateUid, orderInfoVo.getCreateUid())
                    .like(orderInfoVo.getOrderName() != null, OrderInfo::getOrderName, orderInfoVo.getOrderName())
                    .eq(orderInfoVo.getState() != null, OrderInfo::getState, orderInfoVo.getState());
        }
        if (!isAdmin) {
            lambdaQueryWrapper.eq(orderInfoVo.getId() !=null, OrderInfo::getId, orderInfoVo.getId())
                    .eq(orderInfoVo.getDId() != null, OrderInfo::getDId, orderInfoVo.getDId())
                    .eq(orderInfoVo.getCreateUid() != null, OrderInfo::getCreateUid, sysUser.getId())
                    .like(orderInfoVo.getOrderName() != null, OrderInfo::getOrderName, orderInfoVo.getOrderName())
                    .eq(orderInfoVo.getState() != null, OrderInfo::getState, orderInfoVo.getState());
        }
        return ResultObj.ok().data(orderListMapper.selectPage(page, lambdaQueryWrapper));
    }
}
