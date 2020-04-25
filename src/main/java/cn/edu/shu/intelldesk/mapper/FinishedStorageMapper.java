package cn.edu.shu.intelldesk.mapper;

import cn.edu.shu.intelldesk.entity.FinishedStorage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FinishedStorageMapper {

    FinishedStorage getAllFinishedStorageById(Integer id);

    List<FinishedStorage> getAllFinishedStorage();

    FinishedStorage getFinishedStorageById(Integer storageId);

    void removeOrderLinkWithFinishedStorage(Integer storageId);
}
