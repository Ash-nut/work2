package cn.helloworld1999.work2.controller;

import cn.helloworld1999.work2.bean.vo.OrderInfoVo;
import cn.helloworld1999.work2.service.OrderListService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/OrderListController")
public class OrderListController {
    @Resource
    OrderListService orderListService;
    @RequestMapping("findAll")
    public Object findAll(HttpSession session,@RequestBody OrderInfoVo orderInfoVo) {
        return orderListService.findAll(session, orderInfoVo);
    }
}
