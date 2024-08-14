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
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("order_node")
public class OrderNode {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;
    @TableField("o_id")
    private Long oId;
    @TableField("order_of_approval")
    private String orderOfApproval;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableField("u_id")
    private Long uId;
    @TableField("update_time")
    private Date updateTime;
    @TableField("result_of_handling")
    private String resultOfHandling;
    private String remark;
}
