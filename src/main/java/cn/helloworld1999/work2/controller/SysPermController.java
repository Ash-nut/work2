package cn.helloworld1999.work2.controller;

import cn.helloworld1999.work2.bean.vo.SysPermVo;
import cn.helloworld1999.work2.service.SysPermService;
import cn.helloworld1999.work2.util.ResultObj;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SysPermController")
public class SysPermController {
    @Resource
    private SysPermService sysPermService;
    @RequestMapping("addPerm")
    ResultObj addPerm(@RequestBody SysPermVo sysPermVo) {
        return sysPermService.addPerm(sysPermVo);
    }
    @RequestMapping("findAll")
    ResultObj findAll(@RequestBody SysPermVo sysPermVo) {
        return sysPermService.findAll(sysPermVo);
    }
    @RequestMapping("logicDeletePerm")
    ResultObj logicDeletePerm(@RequestBody SysPermVo sysPermVo) {
        return sysPermService.logicDeletePerm(sysPermVo);
    }
    @RequestMapping("updatePerm")
    ResultObj updatePerm(@RequestBody SysPermVo sysPermVo) {
        return sysPermService.updatePerm(sysPermVo);
    }
}
