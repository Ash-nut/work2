package cn.helloworld1999.work2.service;

import cn.helloworld1999.work2.bean.RelUserRole;
import cn.helloworld1999.work2.bean.SysRole;
import cn.helloworld1999.work2.bean.SysUser;
import cn.helloworld1999.work2.bean.vo.SysRoleVo;
import cn.helloworld1999.work2.bean.vo.SysUserVo;
import cn.helloworld1999.work2.util.ResultObj;
import jakarta.servlet.http.HttpSession;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface SysRoleService {
    /**
     * 查询所有角色信息
     *
     * @param sysRoleVo 角色查询条件对象，用于筛选角色信息
     * @return 包含所有角色信息的ResultObj对象
     */
    ResultObj findAll(SysRoleVo sysRoleVo);

    /**
     * 更新角色信息
     *
     * @param sysRoleVo 待更新的角色信息对象
     * @return 更新操作结果，ResultObj对象中包含更新后的角色信息
     */
    ResultObj updateRole(SysRoleVo sysRoleVo);

    /**
     * 逻辑删除角色
     *
     * @param sysRoleVo 待删除的角色信息对象
     * @return 删除操作结果，ResultObj对象中包含删除后的角色信息（如标记为删除的状态字段）
     */
    ResultObj logicDeleteRole(SysRoleVo sysRoleVo);

    /**
     * 添加新角色
     *
     * @param sysRoleVo 新角色的信息对象
     * @return 添加操作结果，ResultObj对象中包含新添加的角色信息
     */
    ResultObj addRole(SysRoleVo sysRoleVo);

    /**
     * 根据用户查询角色信息
     *
     * @param session 当前会话，用于获取用户信息
     * @param sysUser 用户查询条件对象，用于筛选用户相关的角色信息
     * @return 包含用户角色信息的List<SysRole>对象
     */
    List<SysRole> findUserRole(HttpSession session, SysUser sysUser);
}
