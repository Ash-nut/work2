package cn.helloworld1999.work2.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_perms")
public class SysPerm {
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;
    private Long pid;
    @TableField("perm_name")
    private String permName;
    private String route;
    @TableLogic
    @TableField("is_delete")
    private Integer isDelete;
}
