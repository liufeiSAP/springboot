package online.zhaopei.myproject.service.impl;

import online.zhaopei.myproject.domain.ArchiveRecordHistory;
import online.zhaopei.myproject.mapper.primary.ArchiveRecordHistoryMapper;
import online.zhaopei.myproject.mapper.primary.ArchiveRecordMapper;
import online.zhaopei.myproject.service.ArchiveRecordHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArchiveRecordHistoryServiceImpl implements ArchiveRecordHistoryService {

    @Autowired
    private ArchiveRecordHistoryMapper recordHistoryMapper;

    @Override
    @Transactional(value = "primaryTxMan", readOnly = true)
    public List<ArchiveRecordHistory> findByCondition(String refStart, String refEnd, String archiveNum, String owner, String user, String status, String returnStart, String returnEnd) {
        return this.recordHistoryMapper.findByCondition(refStart, refEnd, archiveNum, owner, user, status, returnStart, returnEnd);
    }

    @Override
    public void add(ArchiveRecordHistory record) {
        recordHistoryMapper.add(record);
    }
}
