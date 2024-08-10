package cn.helloworld1999.work2.service.impl;
import cn.helloworld1999.work2.bean.SysUser;
import cn.helloworld1999.work2.bean.vo.SysUserVo;
import cn.helloworld1999.work2.mapper.SysUserMapper;
import cn.helloworld1999.work2.service.SysUserService;
import cn.helloworld1999.work2.util.ResultObj;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public ResultObj findAll(SysUserVo sysUserVo) {
        Page<SysUser> page = new Page<>(sysUserVo.getCurrentPage(), sysUserVo.getPageSize());
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        if (sysUserVo.getId() != null) {
            queryWrapper.eq(SysUser::getId, sysUserVo.getId());
        } else {
            queryWrapper.like(sysUserVo.getAccount() != null, SysUser::getAccount, sysUserVo.getAccount())
                    .like(sysUserVo.getPassword() != null, SysUser::getPassword, sysUserVo.getPassword())
                    .like(sysUserVo.getName() != null, SysUser::getName, sysUserVo.getName())
                    .like(sysUserVo.getPhoneNumber() != null, SysUser::getPhoneNumber, sysUserVo.getPhoneNumber())
                    .like(sysUserVo.getGender() != null, SysUser::getGender, sysUserVo.getGender())
                    .like(sysUserVo.getBirthdate() != null, SysUser::getBirthdate, sysUserVo.getBirthdate())
                    .like(sysUserVo.getRolesId() != null, SysUser::getRolesId, sysUserVo.getRolesId())
                    .like(sysUserVo.getImgPath() != null, SysUser::getImgPath, sysUserVo.getImgPath());
        }
        return ResultObj.ok().data(sysUserMapper.selectPage(page, queryWrapper));
    }

    @Override
    public ResultObj updateUser(SysUserVo sysUserVo) {
        if (sysUserMapper.updateById(sysUserVo)==1){
            return ResultObj.ok();
        }
        return ResultObj.error();
    }

    @Override
    public ResultObj logicDeleteUser(SysUserVo sysUserVo) {
        if (sysUserMapper.deleteById(sysUserVo.getId())==1){
            return ResultObj.ok();
        }
        return ResultObj.error();
    }
    public ResultObj addUser(SysUserVo sysUserVo) {
        if (sysUserMapper.insert(sysUserVo)==1){
            return ResultObj.ok();
        }
        return ResultObj.error();
    }
}
