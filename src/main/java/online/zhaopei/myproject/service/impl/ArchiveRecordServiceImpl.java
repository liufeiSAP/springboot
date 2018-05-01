package online.zhaopei.myproject.service.impl;

import online.zhaopei.myproject.domain.ArchiveRecord;
import online.zhaopei.myproject.domain.City;
import online.zhaopei.myproject.mapper.primary.ArchiveRecordMapper;
import online.zhaopei.myproject.mapper.primary.CityMapper;
import online.zhaopei.myproject.service.ArchiveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArchiveRecordServiceImpl implements ArchiveRecordService {

    @Autowired
    private ArchiveRecordMapper recordMapper;

    @Override
    @Transactional(value = "primaryTxMan", readOnly = true)
    public List<ArchiveRecord> findByCondition(String refStart, String refEnd, String archiveNum, String owner,String  user,String status, String returnStart,String returnEnd) {
        return this.recordMapper.findByCondition(refStart, refEnd, archiveNum, owner, user, status, returnStart, returnEnd);
    }

    @Override
    public void add(ArchiveRecord record) {
        recordMapper.add(record);
    }

    @Override
    public void delete(String id) {
        recordMapper.delete(id);
    }

    @Override
    public void update(ArchiveRecord record) {
        recordMapper.update(record);
    }
}
