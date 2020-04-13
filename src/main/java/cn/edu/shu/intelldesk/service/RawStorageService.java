package cn.edu.shu.intelldesk.service;

import cn.edu.shu.intelldesk.entity.OrderList;
import cn.edu.shu.intelldesk.entity.RawStorage;
import cn.edu.shu.intelldesk.mapper.RawStorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawStorageService {
    @Autowired
    RawStorageMapper rawStorageMapper;


    public List<RawStorage> getAllRawStorage() {
        return rawStorageMapper.getAllRawStorage();
    }
}
