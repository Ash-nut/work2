package cn.helloworld1999.work2.controller;

import cn.helloworld1999.work2.bean.vo.SysUserVo;
import cn.helloworld1999.work2.service.SysRoleService;
import cn.helloworld1999.work2.service.SysUserService;
import cn.helloworld1999.work2.util.ResultObj;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/LoginController")
public class LoginController {
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysRoleService sysRoleService;
    @RequestMapping("login")
    ResultObj login(HttpSession session, @RequestBody SysUserVo sysUserVo) {
        return sysUserService.login(session, sysUserVo);
    }

    @RequestMapping("logout")
    ResultObj logout (HttpSession session){
        return sysUserService.logout(session);
    }
    @RequestMapping("signIn")
    ResultObj signIn(@RequestBody SysUserVo sysUserVo) {
        return sysUserService.signIn(sysUserVo);
    }
    @RequestMapping("findUserRole")
    ResultObj findUserRole(HttpSession session,SysUserVo sysUserVo) {
        return ResultObj.ok().data(sysRoleService.findUserRole(session, sysUserVo));
    }
}
