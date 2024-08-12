package cn.helloworld1999.work2.service;

import cn.helloworld1999.work2.bean.vo.SysUserVo;
import cn.helloworld1999.work2.util.ResultObj;
import jakarta.servlet.http.HttpSession;

public interface SysUserService {
    ResultObj findAll(SysUserVo sysUserVo);
    ResultObj updateUser(SysUserVo sysUserVo);
    ResultObj logicDeleteUser(SysUserVo sysUserVo);
    ResultObj addUser(SysUserVo sysUserVo);
    ResultObj login(HttpSession session, SysUserVo sysUserVo);
    ResultObj logout(HttpSession session);
    ResultObj signIn(SysUserVo sysUserVo);
}
