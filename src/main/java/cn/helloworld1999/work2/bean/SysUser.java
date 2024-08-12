package cn.helloworld1999.work2.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_users")
public class SysUser {
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;
    private String account;
    private String password;
    private String name;
    @TableField("phone_number")
    private String phoneNumber;
    private String gender;
    private Date birthdate;
    @TableField("roles_id")
    private Long rolesId;
    @TableField("img_path")
    private String imgPath;
    @TableLogic
    @TableField("is_delete")
    private int isDelete;
}
