package cn.edu.shu.intelldesk.controller;


import cn.edu.shu.intelldesk.entity.FinishedStorage;
import cn.edu.shu.intelldesk.entity.Menu;
import cn.edu.shu.intelldesk.entity.Role;
import cn.edu.shu.intelldesk.mapper.MenuMapper;
import cn.edu.shu.intelldesk.mapper.UserMapper;
import cn.edu.shu.intelldesk.service.FinishedStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
