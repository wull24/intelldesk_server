package cn.edu.shu.intelldesk.service;

import cn.edu.shu.intelldesk.entity.FinishedStorage;
import cn.edu.shu.intelldesk.mapper.FinishedStorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinishedStorageService {
    @Autowired
    FinishedStorageMapper finishedStorageMapper;

    public FinishedStorage getAllFinishedStorageById( Integer id){
        FinishedStorage finishedStorage= finishedStorageMapper.getAllFinishedStorageById(id);
        return finishedStorage;
    }
}
