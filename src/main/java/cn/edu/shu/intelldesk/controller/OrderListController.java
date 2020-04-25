package cn.edu.shu.intelldesk.controller;

import cn.edu.shu.intelldesk.entity.OrderList;
import cn.edu.shu.intelldesk.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orderList")
public class OrderListController {
    @Autowired
    OrderListService orderListService;

    /**
     * 获得一页订单
     * @return
     */
    @GetMapping("/getOrderListByPage")
    public Map<String ,Object> getOrderListByPge(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ){
        Map<String , Object> map = new HashMap<>();
        List<OrderList> orderListByPage = orderListService.getOrderListByPage(page, size);
        Integer totalCount = orderListService.getTotalCount();
        map.put("orderList",orderListByPage);
        map.put("totalCount",totalCount);
        return map;

    }

    @GetMapping("/getAllOrderList")
    public Map<String,Integer> getAllOrderList(){
        return orderListService.getOrderStateNum();
    }
}
