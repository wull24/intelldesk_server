package cn.edu.shu.intelldesk.mapper;

import cn.edu.shu.intelldesk.entity.FinishedStorage;
import org.springframework.stereotype.Component;

@Component
public interface FinishedStorageMapper {

    FinishedStorage getAllFinishedStorageById(Integer id);
}
