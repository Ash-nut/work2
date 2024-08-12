package cn.helloworld1999.work2.service.impl;
import cn.helloworld1999.work2.bean.SysPerm;
import cn.helloworld1999.work2.bean.SysRole;
import cn.helloworld1999.work2.bean.vo.SysPermVo;
import cn.helloworld1999.work2.mapper.SysPermMapper;
import cn.helloworld1999.work2.service.SysPermService;
import cn.helloworld1999.work2.util.ResultObj;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SysPermServiceImpl implements SysPermService {
    @Resource
    private SysPermMapper sysPermMapper;

    @Override
    public ResultObj findAll(SysPermVo sysPermVo) {
        Page<SysPerm> page = new Page<>(sysPermVo.getCurrentPage(), sysPermVo.getPageSize());
        LambdaQueryWrapper<SysPerm> queryWrapper = new LambdaQueryWrapper<>();
        if (sysPermVo.getId() != null) {
            queryWrapper.eq(SysPerm::getId, sysPermVo.getId());
        } else {
            queryWrapper.like(sysPermVo.getPid() != null, SysPerm::getPid, sysPermVo.getPid())
                    .like(sysPermVo.getRoute() != null, SysPerm::getRoute, sysPermVo.getRoute());
        }
        return ResultObj.ok().data(sysPermMapper.selectPage(page, queryWrapper));
    }

    @Override
    public ResultObj updatePerm(SysPermVo sysPermVo) {
        if (sysPermMapper.updateById(sysPermVo) == 1) {
            return ResultObj.ok();
        }
        return ResultObj.error();
    }

    @Override
    public ResultObj logicDeletePerm(SysPermVo sysPermVo) {
        if (sysPermMapper.deleteById(sysPermVo.getId()) == 1) {
            return ResultObj.ok();
        }
        return ResultObj.error();
    }

    @Override
    public ResultObj addPerm(SysPermVo sysPermVo) {
        if (sysPermMapper.insert(sysPermVo) == 1) {
            return ResultObj.ok();
        }
        return ResultObj.error();
    }

    @Override
    public ResultObj findRolePerm(SysRole sysRole) {
        LambdaQueryWrapper<SysPerm> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysPerm::getId, sysRole.getPermId());
        return ResultObj.ok().data(sysPermMapper.selectOne(queryWrapper));
    }
}
