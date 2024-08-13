package cn.helloworld1999.work2.service.impl;

import cn.helloworld1999.work2.bean.MenuBody;
import cn.helloworld1999.work2.bean.SysPerm;
import cn.helloworld1999.work2.bean.SysRole;
import cn.helloworld1999.work2.mapper.SysRoleMapper;
import cn.helloworld1999.work2.service.MenuService;
import cn.helloworld1999.work2.service.SysPermService;
import cn.helloworld1999.work2.util.ResultObj;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysPermService sysPermService;

    public MenuServiceImpl(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

    @Override
    public ResultObj createRoleMenu(HttpSession session) {
        SysRole sysRole = (SysRole) session.getAttribute("sysRole");

        List<SysPerm> sysPerms = (List<SysPerm>) sysPermService.findRolePerm(sysRole).getData();
        System.out.println("查询到的权限为：" + sysPerms.toString());

        // 确保MenuBody对象正确创建并填充数据
        MenuBody menuBody = new MenuBody();
        List<MenuBody> menuBodysList = menuBody.sysPermsToMenuBody(sysPerms);
        System.out.println("拼装的MenuList为:" + menuBodysList.toString());

        // 散装的结构化Map
        Map<Long, MenuBody> menuBodyMap = new HashMap<>();
        for (MenuBody menuBody0 : menuBodysList) {
            // 使用默认值0处理null情况
            Long pid = Optional.ofNullable(menuBody0.getPid()).orElse(0L);
            System.out.println(pid);
            menuBodyMap.put(menuBody0.getId(), menuBody0);
        }

        // 结构化顶级节点列表
        List<MenuBody> menuBodyEnd = new ArrayList<>();
        for (MenuBody menuBody1 : menuBodysList) {
            // 将null视为顶级节点
            Long pid = Optional.ofNullable(menuBody1.getPid()).orElse(0L);
            if (pid == 0) {
                menuBodyEnd.add(menuBody1);
            } else {
                // 利用 java 的“对象皆引用”的特点，直接在父节点的children中添加子节点
                MenuBody parentMenuBody = menuBodyMap.get(pid);
                if (parentMenuBody != null && parentMenuBody.getChildren() == null) {
                    parentMenuBody.setChildren(new ArrayList<>());
                }
                if (parentMenuBody != null) {
                    parentMenuBody.getChildren().add(menuBody1);
                }
            }
        }
        return ResultObj.ok().data(menuBodyEnd);
    }

    @Override
    public ResultObj choosingRole(HttpSession session, SysRole sysRole) {
        session.setAttribute("sysRole",sysRoleMapper.selectById(sysRole.getId()));
        if (sysRole.getId() == null){
            return ResultObj.error();
        }
        return ResultObj.ok().data(sysRole);
    }
}
