package cn.edu.shu.intelldesk.controller;

import cn.edu.shu.intelldesk.entity.Material;
import cn.edu.shu.intelldesk.entity.RawStorage;
import cn.edu.shu.intelldesk.service.RawStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("/addMaterialToStorageById")
    public void addMaterialToStorageById(String  storageId,String  materialId){
        Integer sid = Integer.parseInt(storageId);
        Integer mid = Integer.parseInt(materialId);
        rawStorageService.addMaterialToStorageById(storageId,materialId);
    }

    @PutMapping("/removeMaterialFromStorageById")
    public  void removeMaterialFromStorageById(String storageId){
       Integer sid  = Integer.parseInt(storageId);
       rawStorageService.removeMaterialFromStorageById(sid);
    }


}
