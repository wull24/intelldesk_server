package cn.edu.shu.intelldesk.mapper;

import cn.edu.shu.intelldesk.entity.Menu;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MenuMapper {

    List<Menu> getMenusByUserId(long userId);
}
