package online.zhaopei.myproject.sqlprovide;

import org.apache.ibatis.jdbc.SQL;

public class RecordSqlProvide {
    public String findByState(String state) {

        return new SQL() {{
            this.SELECT("*").FROM("archiverecord");
        }}.toString();
    }
}
