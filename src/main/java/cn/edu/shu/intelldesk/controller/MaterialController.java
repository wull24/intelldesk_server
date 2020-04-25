package cn.edu.shu.intelldesk.controller;

import cn.edu.shu.intelldesk.entity.Material;
import cn.edu.shu.intelldesk.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/material")
@RestController
public class MaterialController {
    @Autowired
    MaterialService materialService;
    @GetMapping("/getAllMaterial")
    public List<Material> getAllMaterial(){
        return materialService.getAllMaterial();
    }
}
