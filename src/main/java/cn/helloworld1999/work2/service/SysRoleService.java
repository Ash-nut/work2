package cn.helloworld1999.work2.service;

import cn.helloworld1999.work2.bean.vo.SysRoleVo;
import cn.helloworld1999.work2.util.ResultObj;

public interface SysRoleService {
    ResultObj findAll(SysRoleVo sysRoleVo);
    ResultObj updateRole(SysRoleVo sysRoleVo);
    ResultObj logicDeleteRole(SysRoleVo sysRoleVo);
    ResultObj addRole(SysRoleVo sysRoleVo);
}
