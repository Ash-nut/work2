package cn.helloworld1999.work2.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("rel_user_role")
public class RelUserRole {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Long uid;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Long rid;
}
