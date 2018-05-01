package online.zhaopei.myproject.service;

import online.zhaopei.myproject.domain.ArchiveRecord;
import online.zhaopei.myproject.domain.City;

import java.util.List;

public interface ArchiveRecordService {
    List<ArchiveRecord> findByCondition(String refStart, String refEnd, String archiveNum, String owner,String  user,String status, String returnStart,String returnEnd);
    void add(ArchiveRecord  record);
    void delete(String id);
    void update(ArchiveRecord record);
}
