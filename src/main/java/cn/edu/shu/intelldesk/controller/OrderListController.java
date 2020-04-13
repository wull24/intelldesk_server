package cn.edu.shu.intelldesk.controller;

import cn.edu.shu.intelldesk.entity.OrderList;
import cn.edu.shu.intelldesk.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderList")
public class OrderListController {
    @Autowired
    OrderListService orderListService;

    /**
     * 获得所有的订单
     * @return
     */
    @GetMapping("/getAllOrderList")
    public List<OrderList> getAllOrderList(){
    return orderListService.getAllOrderList();
    }
}
