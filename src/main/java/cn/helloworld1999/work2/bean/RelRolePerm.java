package cn.helloworld1999.work2.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.security.auth.login.LoginContext;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("rel_role_perm")
public class RelRolePerm {
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    Long id;
    Long rid;
    Long pid;
}
