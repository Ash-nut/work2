package cn.helloworld1999.work2.service;
import cn.helloworld1999.work2.bean.vo.SysUserVo;
import cn.helloworld1999.work2.util.ResultObj;
import jakarta.servlet.http.HttpSession;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SysUserService {
    /**
     * 查询所有用户信息
     *
     * @param sysUserVo 用户查询条件封装对象
     * @return ResultObj 包含查询结果和可能的错误信息
     */
    ResultObj findAll(SysUserVo sysUserVo);

    /**
     * 更新用户信息
     *
     * @param sysUserVo 包含需更新用户信息的封装对象
     * @return ResultObj 表示操作结果，包含更新结果和可能的错误信息
     */
    ResultObj updateUser(SysUserVo sysUserVo);

    /**
     * 逻辑删除用户
     *
     * @param sysUserVo 包含需删除用户信息的封装对象
     * @return ResultObj 表示操作结果，包含删除结果和可能的错误信息
     */
    ResultObj logicDeleteUser(SysUserVo sysUserVo);

    /**
     * 添加新用户
     *
     * @param sysUserVo 包含新用户信息的封装对象
     * @return ResultObj 表示操作结果，包含添加结果和可能的错误信息
     */
    ResultObj addUser(SysUserVo sysUserVo);

    /**
     * 用户登录
     *
     * @param session 用户会话对象，用于管理用户会话
     * @param sysUserVo 包含登录用户信息的封装对象
     * @return ResultObj 表示操作结果，包含登录结果和可能的错误信息
     */
    ResultObj login(HttpSession session, SysUserVo sysUserVo);

    /**
     * 用户登出
     *
     * @param session 用户会话对象，用于结束当前用户会话
     * @return ResultObj 表示操作结果，包含登出结果和可能的错误信息
     */
    ResultObj logout(HttpSession session);

    /**
     * 用户注册
     *
     * @param sysUserVo 包含注册用户信息的封装对象
     * @return ResultObj 表示操作结果，包含注册结果和可能的错误信息
     */
    ResultObj signIn(SysUserVo sysUserVo);


}
