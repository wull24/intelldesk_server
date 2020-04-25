package cn.edu.shu.intelldesk.controller;


import cn.edu.shu.intelldesk.entity.FinishedStorage;
import cn.edu.shu.intelldesk.entity.Menu;
import cn.edu.shu.intelldesk.entity.OrderList;
import cn.edu.shu.intelldesk.entity.Role;
import cn.edu.shu.intelldesk.mapper.MenuMapper;
import cn.edu.shu.intelldesk.mapper.OrderListMapper;
import cn.edu.shu.intelldesk.mapper.UserMapper;
import cn.edu.shu.intelldesk.service.FinishedStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    FinishedStorageService finishedStorageService;

    @Autowired
    UserMapper userMapper;
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    OrderListMapper orderListMapper;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/fs")
    public FinishedStorage getFinishedStorageById(){
        System.out.println("1111");
       return finishedStorageService.getAllFinishedStorageById(1);
    }

    @GetMapping("/menu")
    public List<Menu> getRole(long l){
        return menuMapper.getMenusByUserId(l);
    }

    @PutMapping("/updateOrderlist")
    public void updateOrderlist(){
        OrderList ol = orderListMapper.getOrderListById(1);
        System.out.println(ol);
        ol.setState("已完成");
        ol.setFinishedTime(new Date());
        orderListMapper.updateOrder(ol);
    }

}
