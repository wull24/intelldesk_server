package cn.edu.shu.intelldesk.service;

import cn.edu.shu.intelldesk.entity.OrderList;
import cn.edu.shu.intelldesk.mapper.OrderListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderListService {
    @Autowired
    OrderListMapper orderListMapper;
    //获取所有的库存信息
    public List<OrderList> getAllOrderList(){
        return orderListMapper.getAllOrderList();
    }
}
