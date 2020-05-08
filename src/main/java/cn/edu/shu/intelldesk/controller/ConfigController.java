package cn.edu.shu.intelldesk.controller;

import cn.edu.shu.intelldesk.entity.Menu;
import cn.edu.shu.intelldesk.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    MenuService menuService;

    @GetMapping("/getMenu")
    public List<Menu> getMenu(){
        return menuService.geMenusByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
