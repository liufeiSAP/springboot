package online.zhaopei.myproject.mapper.primary;

import online.zhaopei.myproject.domain.City;
import online.zhaopei.myproject.domain.User;
import online.zhaopei.myproject.sqlprovide.CitySqlProvide;
import online.zhaopei.myproject.sqlprovide.UserSqlProvide;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface UserMapper {

    @SelectProvider(type = UserSqlProvide.class, method = "addUser")
    String addUser(@Param("user") User user);

    @SelectProvider(type = UserSqlProvide.class, method = "deleteUser")
    String deleteUser(@Param("userId") String userId);

    @SelectProvider(type = UserSqlProvide.class, method = "updateUser")
    String updateUser(@Param("user") User user);

    @SelectProvider(type = UserSqlProvide.class, method = "searchUser")
    List<User> searchUser(@Param("userId") String userId);
}
