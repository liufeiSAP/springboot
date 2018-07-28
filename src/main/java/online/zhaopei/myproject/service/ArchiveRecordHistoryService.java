package online.zhaopei.myproject.service;

import online.zhaopei.myproject.domain.ArchiveRecordHistory;

import java.util.List;

public interface ArchiveRecordHistoryService {
    List<ArchiveRecordHistory> findByCondition(String refStart, String refEnd, String archiveNum, String owner, String  user, String status, String returnStart, String returnEnd);
    void add(ArchiveRecordHistory record);
}
