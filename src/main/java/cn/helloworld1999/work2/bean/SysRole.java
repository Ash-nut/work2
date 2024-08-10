package cn.helloworld1999.work2.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_roles")
public class SysRole {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String role;
    @TableField("perm_id")
    private Integer permId;
    @TableLogic
    @TableField("is_delete")
    private Integer isDelete;
}
