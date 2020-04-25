package cn.edu.shu.intelldesk.service;

import cn.edu.shu.intelldesk.entity.Material;
import cn.edu.shu.intelldesk.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    MaterialMapper materialMapper;

    public List<Material> getAllMaterial() {
        return materialMapper.getAllMaterial();
    }
}
