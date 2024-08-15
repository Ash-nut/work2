package cn.helloworld1999.work2.controller;

import cn.helloworld1999.work2.bean.OrderNode;
import cn.helloworld1999.work2.bean.vo.OrderInfoVo;
import cn.helloworld1999.work2.bean.vo.OrderNodeVo;
import cn.helloworld1999.work2.service.OrderNodeService;
import cn.helloworld1999.work2.util.ResultObj;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/OrderNodeController")
public class OrderNodeController {
    @Resource private OrderNodeService orderNodeService;
    @RequestMapping("findAll")
    public Object findAll(HttpSession session, @RequestBody OrderNodeVo orderNodeVo)
    {
        return orderNodeService.findAll(session,orderNodeVo);
    }
    @RequestMapping("backlog")

    ResultObj findAllBacklog(HttpSession session,@RequestBody OrderNodeVo orderNodeVo){
        return orderNodeService.findAllBacklog(session,orderNodeVo);
    }
    @RequestMapping("updateNode")
    public Object updateNode(@RequestBody OrderNode orderNode)
    {
        return orderNodeService.updateNode(orderNode);
    }
    @RequestMapping("findNodeOfOrder")
    public Object findNodeOfOrder(@RequestBody OrderInfoVo orderInfoVo)
    {
        return orderNodeService.findNodeOfOrder(orderInfoVo);
    }
    @RequestMapping("updateBacklog")
    public Object updateBacklog(@RequestBody OrderNode orderNode)
    {
        return orderNodeService.updateBacklog(orderNode);
    }
}
