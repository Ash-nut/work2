/*
package cn.helloworld1999.work2.controller;*/
package cn.helloworld1999.work2.controller;

import cn.helloworld1999.work2.bean.vo.SysRoleVo;
import cn.helloworld1999.work2.service.SysRoleService;
import cn.helloworld1999.work2.util.ResultObj;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/SysRoleController")
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;

    @RequestMapping("findAll")
    ResultObj findAll(@RequestBody SysRoleVo sysRoleVo) {
        return sysRoleService.findAll(sysRoleVo);
    }

    @RequestMapping("logicDeleteRole")
    ResultObj logicDeleteRole(@RequestBody SysRoleVo sysRoleVo) {
        return sysRoleService.logicDeleteRole(sysRoleVo);
    }

    @RequestMapping("updateRole")
    ResultObj updateRole(@RequestBody SysRoleVo sysRoleVo) {
        return sysRoleService.updateRole(sysRoleVo);
    }

    @RequestMapping("addRole")
    ResultObj addRole(@RequestBody SysRoleVo sysRoleVo) {
        System.out.println(sysRoleVo.toString());
        return sysRoleService.addRole(sysRoleVo);
    }
}

