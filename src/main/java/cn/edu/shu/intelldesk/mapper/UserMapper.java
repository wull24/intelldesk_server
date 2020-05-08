package cn.edu.shu.intelldesk.mapper;

import cn.edu.shu.intelldesk.entity.Role;
import cn.edu.shu.intelldesk.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    //检查用户是否存在
    User loadUserByUserName(String username);

    //配合loadUserByUserName进行角色信息的查询
    List<Role> getRolesByUserId(Long id);

}
