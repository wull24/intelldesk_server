package cn.edu.shu.intelldesk.mapper;

import cn.edu.shu.intelldesk.entity.Material;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MaterialMapper {

    List<Material> getAllMaterial();
}
