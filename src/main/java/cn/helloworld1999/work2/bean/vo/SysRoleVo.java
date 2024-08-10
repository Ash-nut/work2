package cn.helloworld1999.work2.bean.vo;

import cn.helloworld1999.work2.bean.SysRole;
import cn.helloworld1999.work2.bean.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRoleVo extends SysRole {
    private Integer pageSize;
    private Integer currentPage;
}
