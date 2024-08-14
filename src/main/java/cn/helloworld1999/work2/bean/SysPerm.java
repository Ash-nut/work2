package cn.helloworld1999.work2.bean;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_perms")
public class SysPerm {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long pid;
    @TableField("perm_name")
    private String permName;
    private String route;
    @TableLogic
    @TableField("is_delete")
    private Integer isDelete;
}
