package cn.edu.shu.intelldesk.service;

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


    public void addMaterialToStorageById(String storageId, String materialId) {
        rawStorageMapper.addMaterialToStorageById(storageId,materialId);
    }

    public void removeMaterialFromStorageById(Integer sid) {
        //1.查询该库位是否存在物料
        RawStorage rs =  rawStorageMapper.getRawStorageById(sid);
        //2.如果存在则删除，
        if(rs.getMaterial() == null){
            return;
        }else{
        rawStorageMapper.removeMaterialFromStorageById(sid);

        }
        //3.否则返回
    }
}
