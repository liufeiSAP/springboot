package online.zhaopei.myproject.service;

import online.zhaopei.myproject.domain.ArchiveRecord;
import online.zhaopei.myproject.domain.City;

import java.util.List;

public interface ArchiveRecordService {

    List<ArchiveRecord> findByState(String state);
}
