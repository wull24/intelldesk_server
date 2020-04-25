package cn.edu.shu.intelldesk.mapper;

import cn.edu.shu.intelldesk.entity.RawStorage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RawStorageMapper {

    List<RawStorage> getAllRawStorage();

    void addMaterialToStorageById(String storageId, String materialId);

    RawStorage getRawStorageById(Integer sid);

    void removeMaterialFromStorageById(Integer sid);
}
