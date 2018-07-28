package online.zhaopei.myproject.mapper.primary;

import online.zhaopei.myproject.domain.ArchiveRecord;
import online.zhaopei.myproject.domain.ArchiveRecordHistory;
import online.zhaopei.myproject.sqlprovide.RecordHistorySqlProvide;
import online.zhaopei.myproject.sqlprovide.RecordSqlProvide;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface ArchiveRecordHistoryMapper {
    @SelectProvider(type = RecordHistorySqlProvide.class, method = "findByCondition")
    List<ArchiveRecordHistory> findByCondition(@Param("refStart")String refStart,
                                               @Param("refEnd")String refEnd,
                                               @Param("archiveNum")String archiveNum,
                                               @Param("owner")String owner,
                                               @Param("user")String  user,
                                               @Param("status")String status,
                                               @Param("returnStart")String returnStart,
                                               @Param("returnEnd")String returnEnd);

    @SelectProvider(type = RecordHistorySqlProvide.class, method = "add")
    void add(@Param("record")ArchiveRecordHistory record);
}
