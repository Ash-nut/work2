package cn.helloworld1999.work2.bean.vo;

import cn.helloworld1999.work2.bean.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserVo extends SysUser {
    private Integer pageSize;
    private Integer currentPage;
}
