package cn.edu.shu.intelldesk.controller;


import cn.edu.shu.intelldesk.entity.FinishedStorage;
import cn.edu.shu.intelldesk.service.FinishedStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    FinishedStorageService finishedStorageService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/fs")
    public FinishedStorage getFinishedStorageById(){
        System.out.println("1111");
       return finishedStorageService.getAllFinishedStorageById(1);
    }

}
