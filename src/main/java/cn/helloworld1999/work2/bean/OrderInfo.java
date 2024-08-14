package cn.helloworld1999.work2.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("order_info")
public class OrderInfo {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableField(value = "d_id")
    private Long dId;
    @TableField(value = "order_name")
    private String orderName;
    @TableField(value = "create_datetime")
    private Date createDatetime;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableField(value = "create_uid")
    private Long createUid;
    private String state;
    private String content;
    private String remark;
}
