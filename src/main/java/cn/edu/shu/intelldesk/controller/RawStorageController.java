package cn.edu.shu.intelldesk.controller;

import cn.edu.shu.intelldesk.entity.RawStorage;
import cn.edu.shu.intelldesk.service.RawStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rawStorage")
public class RawStorageController {
    @Autowired
    RawStorageService rawStorageService;

    @GetMapping("/getAllRawStorage")
    public List<RawStorage> getAllRawStorage(){
        return rawStorageService.getAllRawStorage();
    }

}
