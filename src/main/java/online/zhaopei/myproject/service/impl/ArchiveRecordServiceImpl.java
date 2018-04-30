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
    public List<ArchiveRecord> findByState(String state) {
        return this.recordMapper.findByState(state);
    }
}
