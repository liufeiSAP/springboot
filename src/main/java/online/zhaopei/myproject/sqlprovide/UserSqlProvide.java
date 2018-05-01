package online.zhaopei.myproject.sqlprovide;

import com.ctc.wstx.util.StringUtil;
import online.zhaopei.myproject.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvide {

    public String addUser(User user) {
        return new SQL() {{
            this.INSERT_INTO("users")
                    .VALUES("username","#{user.username}")
                    .VALUES("email","#{user.email}")
                    .VALUES("password","#{user.password}")
                    .VALUES("type","#{user.type}");
        }}.toString();
    }

    public String deleteUser(String userId) {
        return new SQL() {{
            this.DELETE_FROM("users").WHERE("id=#{userId}");
        }}.toString();
    }

    public String updateUser(User user) {
        return new SQL() {{
            this.UPDATE("users")
                    .SET("username=#{user.username}")
                    .SET("email = #{user.email}")
                   .SET("password = #{user.password}")
                   .SET("type=#{user.type}")
                    .WHERE("id=#{user.id}");
        }}.toString();
    }

    public String searchUser(final String userId) {
        return new SQL() {{
            SQL sql = this.SELECT("*").FROM("users");
            if (StringUtils.isNotBlank(userId)) {
                sql.WHERE("id=#{userId}");
            }
        }}.toString();
    }
}
