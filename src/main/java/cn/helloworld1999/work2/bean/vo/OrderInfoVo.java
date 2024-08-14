package cn.helloworld1999.work2.bean.vo;

import cn.helloworld1999.work2.bean.OrderInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfoVo extends OrderInfo {
    private Integer pageSize;
    private Integer currentPage;
}
