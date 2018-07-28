package online.zhaopei.myproject.sqlprovide;

import online.zhaopei.myproject.domain.ArchiveRecord;
import online.zhaopei.myproject.domain.ArchiveRecordHistory;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class RecordHistorySqlProvide {
    public String findByCondition(final String refStart, final String refEnd, final String archiveNum,
                                  final String owner,final String user, final String status,
                                  final String returnStart, final String returnEnd) {
        return new SQL() {{
            SQL sql= this.SELECT("*").FROM("archiverecordhistory");
            if(StringUtils.isNotBlank(refStart)) {
                sql.WHERE("Date(referdate) >=#{refStart}");
            }
            if(StringUtils.isNotBlank(refEnd)) {
                sql.WHERE("Date(referdate) <=#{refEnd}");
            }
            if(StringUtils.isNotBlank(archiveNum)) {
                sql.WHERE("archiveNum =#{archiveNum}");
            }
            if(StringUtils.isNotBlank(owner)) {
                sql.WHERE("owner =#{owner}");
            }
            if(StringUtils.isNotBlank(user)) {
                sql.WHERE("user=#{user}");
            }
            if(StringUtils.isNotBlank(status)) {
                sql.WHERE("status =#{status}");
            }
            if(StringUtils.isNotBlank(returnStart)) {
                sql.WHERE("Date(returndate) >=#{returnStart}");
            }
            if(StringUtils.isNotBlank(returnEnd)) {
                sql.WHERE("Date(returndate) <=#{returnEnd}");
            }

            System.out.println(sql.toString());
        }}.toString();
    }

    public String add(ArchiveRecordHistory record) {
        return new SQL() {{
            //this.SELECT("*").FROM("archiverecord");
            this.INSERT_INTO("archiverecordhistory")
                    .VALUES("referdate","#{record.referdate}")
                    .VALUES("archiveNum","#{record.archiveNum}")
                    .VALUES("owner","#{record.owner}")
                    .VALUES("user","#{record.user}")
                    .VALUES("status","#{record.status}")
                    .VALUES("returndate","#{record.returndate}");
        }}.toString();
    }
}
