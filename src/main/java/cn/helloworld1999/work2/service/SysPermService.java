package cn.helloworld1999.work2.service;
import cn.helloworld1999.work2.bean.SysPerm;
import cn.helloworld1999.work2.bean.SysRole;
import cn.helloworld1999.work2.bean.vo.SysPermVo;
import cn.helloworld1999.work2.util.ResultObj;

public interface SysPermService {
    /**
     * 查询所有权限信息
     *
     * @param sysPermVo 权限查询条件封装对象
     * @return 返回包含查询结果和可能的错误信息的ResultObj对象
     */
    ResultObj findAll(SysPermVo sysPermVo);

    /**
     * 更新权限信息
     *
     * @param sysPermVo 待更新的权限信息封装对象
     * @return 返回包含更新结果和可能的错误信息的ResultObj对象
     */
    ResultObj updatePerm(SysPermVo sysPermVo);

    /**
     * 逻辑删除权限
     *
     * @param sysPermVo 待删除的权限信息封装对象
     * @return 返回包含删除结果和可能的错误信息的ResultObj对象
     */
    ResultObj logicDeletePerm(SysPermVo sysPermVo);

    /**
     * 添加新的权限信息
     *
     * @param sysPermVo 新权限信息封装对象
     * @return 返回包含添加结果和可能的错误信息的ResultObj对象
     */
    ResultObj addPerm(SysPermVo sysPermVo);

    /**
     * 根据角色查找权限
     *
     * @param sysRole 角色信息对象
     * @return 返回包含查找结果和可能的错误信息的ResultObj对象
     */
    ResultObj findRolePerm(SysRole sysRole);
}

