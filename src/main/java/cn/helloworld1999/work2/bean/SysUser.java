package cn.helloworld1999.work2.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
    private Integer rolesId;
    @TableField("img_path")
    private String imgPath;
    @TableField("is_delete")
    private int isDelete;
}
