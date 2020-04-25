package cn.edu.shu.intelldesk.service;

import cn.edu.shu.intelldesk.entity.FinishedStorage;
import cn.edu.shu.intelldesk.entity.OrderList;
import cn.edu.shu.intelldesk.mapper.FinishedStorageMapper;
import cn.edu.shu.intelldesk.mapper.OrderListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FinishedStorageService {
    @Autowired
    FinishedStorageMapper finishedStorageMapper;
    @Autowired
    OrderListMapper orderListMapper;

    public FinishedStorage getAllFinishedStorageById( Integer id){
        FinishedStorage finishedStorage= finishedStorageMapper.getAllFinishedStorageById(id);
        return finishedStorage;
    }


    public List<FinishedStorage> getAllMessage() {
        return finishedStorageMapper.getAllFinishedStorage();
    }

    public void takeProductionById(Integer storageId) {
        //1.查询该货格是否有货物
       FinishedStorage fs =  finishedStorageMapper.getFinishedStorageById(storageId);
       if(fs.getOrder() == null){
           return ;
       }else{

           //改变order中的状态
           OrderList ol = orderListMapper.getOrderListById(fs.getOrder().getId());
           ol.setState("已完成");
           ol.setFinishedTime(new Date());
           orderListMapper.updateOrder(ol);
           //2.如果有则消除该货格中的order
           finishedStorageMapper.removeOrderLinkWithFinishedStorage(storageId);

       }
    }
}
