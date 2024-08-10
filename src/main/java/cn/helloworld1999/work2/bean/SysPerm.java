package cn.helloworld1999.work2.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
    private String pid;
    @TableField("perm_name")
    private String permName;
    private String route;
}
