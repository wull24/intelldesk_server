package cn.edu.shu.intelldesk.service;

import cn.edu.shu.intelldesk.entity.User;
import cn.edu.shu.intelldesk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s)throws UsernameNotFoundException{
    User user= userMapper.loadUserByUserName(s);
    if(user  ==null){
    throw new UsernameNotFoundException("用户名不存在");
    }
    return user;
    }

    public Long getUserIdByUserName(String username) {
       User user = userMapper.loadUserByUserName(username);
        return user.getId();
    }
}
