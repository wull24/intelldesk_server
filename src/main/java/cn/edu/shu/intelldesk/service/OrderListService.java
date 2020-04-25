package cn.edu.shu.intelldesk.service;

import cn.edu.shu.intelldesk.entity.OrderList;
import cn.edu.shu.intelldesk.mapper.OrderListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderListService {
    @Autowired
    OrderListMapper orderListMapper;
    //获取所有的库存信息
    public List<OrderList> getOrderListByPage(Integer page, Integer size){
        Integer start = (page-1)*size;
        return orderListMapper.getOrderListByPage(start ,size);
    }

    public Integer getTotalCount() {
        return orderListMapper.getTotalCount();
    }

    public Map<String,Integer> getOrderStateNum() {
        List<OrderList> l = orderListMapper.getAllOrderList();
        Map<String,Integer> map = new HashMap<>();
        Integer wfp=0; Integer p=0;Integer wft = 0;Integer f = 0;
        for(OrderList o :l){

            if(o.getState().equals("待加工")){
                wfp++;
            }else if(o.getState().equals("加工中")){
                p++;
            }else if(o.getState().equals("待取货")){
                wft++;
            }else{
                f++;
            }
        }
            map.put("wfp",wfp);
            map.put("p",p);
            map.put("wft",wft);
            map.put("f",f);
            return map;


    }
}
