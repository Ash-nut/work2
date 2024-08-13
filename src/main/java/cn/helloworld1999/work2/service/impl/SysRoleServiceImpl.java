package cn.helloworld1999.work2.service.impl;

import cn.helloworld1999.work2.bean.RelUserRole;
import cn.helloworld1999.work2.bean.SysRole;
import cn.helloworld1999.work2.bean.SysUser;
import cn.helloworld1999.work2.bean.vo.SysRoleVo;
import cn.helloworld1999.work2.bean.vo.SysUserVo;
import cn.helloworld1999.work2.mapper.RelUserRoleMapper;
import cn.helloworld1999.work2.mapper.SysRoleMapper;
import cn.helloworld1999.work2.service.SysRoleService;
import cn.helloworld1999.work2.util.ResultObj;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private RelUserRoleMapper relUserRoleMapper;

    @Override
    public ResultObj findAll(SysRoleVo sysRoleVo) {
        Page<SysRole> page = new Page<>(sysRoleVo.getCurrentPage(), sysRoleVo.getPageSize());
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        if (sysRoleVo.getId() != null) {
            queryWrapper.eq(SysRole::getId, sysRoleVo.getId());
        } else {
            queryWrapper.like(sysRoleVo.getRole() != null, SysRole::getRole, sysRoleVo.getRole())
                    .like(sysRoleVo.getIsDelete() != null, SysRole::getIsDelete, sysRoleVo.getIsDelete());
        }
        return ResultObj.ok().data(sysRoleMapper.selectPage(page, queryWrapper));
    }

    @Override
    public ResultObj updateRole(SysRoleVo sysRoleVo) {
        if (sysRoleMapper.updateById(sysRoleVo) == 1) {
            return ResultObj.ok();
        }
        return ResultObj.error();
    }

    @Override
    public ResultObj logicDeleteRole(SysRoleVo sysRoleVo) {
        if (sysRoleMapper.deleteById(sysRoleVo.getId()) == 1) {
            return ResultObj.ok();
        }
        return ResultObj.error();
    }

    @Override
    public ResultObj addRole(SysRoleVo sysRoleVo) {
        if (sysRoleMapper.insert(sysRoleVo) == 1) {
            return ResultObj.ok();
        }
        return ResultObj.error();
    }

    /**
     * 通过 SysUserVo 查询角色信息,这个函数我计划在两个地方用：
     * 1.登录系统时，选择角色
     * 2.查询用户信息
     *
     * @param session
     * @param sysUser 允许为空，为空则从 HttpSession 获取
     * @return List<SysRole>
     */
    public List<SysRole> findUserRole(HttpSession session, SysUser sysUser) {
        LambdaQueryWrapper<RelUserRole> relUserRoleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<SysRole> sysRoleVoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        List<RelUserRole> relUserRoleList;
        List<SysRole> sysRoleList = new java.util.ArrayList<>();
        if (sysUser.getId() == null) {
            System.out.println("使用session获取user");
            sysUser = (SysUser) session.getAttribute("user");
            relUserRoleLambdaQueryWrapper.eq(RelUserRole::getUid, sysUser.getId());
        } else {
            System.out.println("使用User获取user");
            relUserRoleLambdaQueryWrapper.eq(RelUserRole::getUid, sysUser.getId());
        }
        relUserRoleList = relUserRoleMapper.selectList(relUserRoleLambdaQueryWrapper);
        for (RelUserRole relUserRole : relUserRoleList) {
            sysRoleVoLambdaQueryWrapper.clear();
            sysRoleVoLambdaQueryWrapper.eq(SysRole::getId, relUserRole.getRid());
            sysRoleList.add(sysRoleMapper.selectOne(sysRoleVoLambdaQueryWrapper));
        }
        return sysRoleList;
    }
}
