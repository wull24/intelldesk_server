package cn.edu.shu.intelldesk.mapper;

import cn.edu.shu.intelldesk.entity.OrderList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderListMapper {

    List<OrderList> getAllOrderList();
}
