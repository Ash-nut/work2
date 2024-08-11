package cn.helloworld1999.work2.bean.vo;
import cn.helloworld1999.work2.bean.SysPerm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPermVo extends SysPerm {
    private Integer pageSize;
    private Integer currentPage;
}
