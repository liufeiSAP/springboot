package online.zhaopei.myproject.mapper.primary;

import online.zhaopei.myproject.domain.ArchiveRecord;
import online.zhaopei.myproject.domain.City;
import online.zhaopei.myproject.sqlprovide.CitySqlProvide;
import online.zhaopei.myproject.sqlprovide.RecordSqlProvide;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface ArchiveRecordMapper {
    @SelectProvider(type = RecordSqlProvide.class, method = "findByCondition")
    List<ArchiveRecord> findByCondition(@Param("refStart")String refStart,
                                        @Param("refEnd")String refEnd,
                                        @Param("archiveNum")String archiveNum,
                                        @Param("owner")String owner,
                                        @Param("user")String  user,
                                        @Param("status")String status,
                                        @Param("returnStart")String returnStart,
                                        @Param("returnEnd")String returnEnd);

}
