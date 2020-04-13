package cn.edu.shu.intelldesk.controller;

import cn.edu.shu.intelldesk.entity.FinishedStorage;
import cn.edu.shu.intelldesk.service.FinishedStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/finishedStorage")
public class FinishedStorageController {
    @Autowired
    FinishedStorageService finishedStorageService;

    @GetMapping("/getAllFinishedStorage")
    public List<FinishedStorage> getAllMessage(){
        return finishedStorageService.getAllMessage();
    }
}
