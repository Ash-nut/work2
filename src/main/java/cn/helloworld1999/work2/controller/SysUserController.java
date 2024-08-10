package cn.helloworld1999.work2.controller;

import cn.helloworld1999.work2.bean.vo.SysUserVo;
import cn.helloworld1999.work2.service.SysUserService;
import cn.helloworld1999.work2.util.ResultObj;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SysUserController")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @RequestMapping("findAll")
    ResultObj findAll(@RequestBody SysUserVo sysUserVo){
        return sysUserService.findAll(sysUserVo);
    }
}
