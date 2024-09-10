package cn.helloworld1999.work2.service.impl;

import cn.helloworld1999.work2.bean.*;
import cn.helloworld1999.work2.mapper.RelUserRoleMapper;
import cn.helloworld1999.work2.mapper.SysRoleMapper;
import cn.helloworld1999.work2.service.SysPermService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.*;
// 测试
@Service
@SpringBootTest
public class RelUserRoleServiceImplTest{
    @Resource
    private RelUserRoleMapper relUserRoleMapper;
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Test

    public void findUserRole() {
        SysUser sysUser = new SysUser();
        sysUser.setId(1L);
        LambdaQueryWrapper<RelUserRole> relUserRoleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<SysRole> sysRoleVoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        List<RelUserRole> relUserRoleList;
        List<SysRole> sysRoleList = new java.util.ArrayList<>();
        relUserRoleLambdaQueryWrapper.eq(RelUserRole::getUid, sysUser.getId());
        relUserRoleList = relUserRoleMapper.selectList(relUserRoleLambdaQueryWrapper);
        for (RelUserRole relUserRole : relUserRoleList) {
            sysRoleVoLambdaQueryWrapper.clear();
            sysRoleVoLambdaQueryWrapper.eq(SysRole::getId, relUserRole.getRid());
            sysRoleList.add(sysRoleMapper.selectOne(sysRoleVoLambdaQueryWrapper));
        }
        System.out.println(sysRoleList);
    }


    @Resource
    private SysPermService sysPermService;

    @Test
    public void createUserMenu() {
        SysRole sysRole = new SysRole();
        sysRole.setId(1L);

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

        System.out.println(menuBodyEnd);
    }

}
