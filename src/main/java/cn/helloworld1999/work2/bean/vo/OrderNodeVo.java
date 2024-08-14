package cn.helloworld1999.work2.bean.vo;

import cn.helloworld1999.work2.bean.OrderNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderNodeVo extends OrderNode {
    private Integer pageSize;
    private Integer currentPage;
}
