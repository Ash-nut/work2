package cn.helloworld1999.work2.service.impl;
import cn.helloworld1999.work2.bean.SysRole;
import cn.helloworld1999.work2.bean.vo.SysRoleVo;
import cn.helloworld1999.work2.mapper.SysRoleMapper;
import cn.helloworld1999.work2.service.SysRoleService;
import cn.helloworld1999.work2.util.ResultObj;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public ResultObj findAll(SysRoleVo sysRoleVo) {
        Page<SysRole> page = new Page<>(sysRoleVo.getCurrentPage(), sysRoleVo.getPageSize());
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        if (sysRoleVo.getId() != null) {
            queryWrapper.eq(SysRole::getId, sysRoleVo.getId());
        } else {
            queryWrapper.like(sysRoleVo.getRole() != null, SysRole::getRole, sysRoleVo.getRole())
                    .like(sysRoleVo.getPermId() != null, SysRole::getPermId, sysRoleVo.getPermId())
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
}
