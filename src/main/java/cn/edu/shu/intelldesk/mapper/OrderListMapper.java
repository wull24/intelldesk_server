package cn.edu.shu.intelldesk.mapper;

import cn.edu.shu.intelldesk.entity.OrderList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface OrderListMapper {

    List<OrderList> getOrderListByPage(@Param("start") Integer start,@Param("size") Integer size);

    OrderList getOrderListById(Integer id);

    void updateOrder( @Param("ol") OrderList ol);

    Integer getTotalCount();

    List<OrderList> getAllOrderList();
}
