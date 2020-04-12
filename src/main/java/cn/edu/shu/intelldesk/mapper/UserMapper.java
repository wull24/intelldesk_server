package cn.edu.shu.intelldesk.mapper;

import cn.edu.shu.intelldesk.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    //检查用户是否存在
    User loadUserByUserName(String username);
}
