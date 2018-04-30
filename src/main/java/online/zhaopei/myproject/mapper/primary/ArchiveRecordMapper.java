package online.zhaopei.myproject.mapper.primary;

import online.zhaopei.myproject.domain.ArchiveRecord;
import online.zhaopei.myproject.domain.City;
import online.zhaopei.myproject.sqlprovide.CitySqlProvide;
import online.zhaopei.myproject.sqlprovide.RecordSqlProvide;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface ArchiveRecordMapper {
    @SelectProvider(type = RecordSqlProvide.class, method = "findByState")
    List<ArchiveRecord> findByState(@Param("state") String state);
}
