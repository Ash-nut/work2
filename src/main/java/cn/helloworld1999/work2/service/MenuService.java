package cn.helloworld1999.work2.service;

import cn.helloworld1999.work2.bean.SysUser;
import cn.helloworld1999.work2.bean.vo.SysUserVo;
import cn.helloworld1999.work2.util.ResultObj;
import jakarta.servlet.http.HttpSession;

public interface MenuService {
    ResultObj createRoleMenu(HttpSession session);
}
