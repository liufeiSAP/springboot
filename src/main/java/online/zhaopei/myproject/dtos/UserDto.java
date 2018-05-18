package online.zhaopei.myproject.dtos;

import org.codehaus.jackson.annotate.JsonProperty;

public class UserDto {
    @JsonProperty(value="user_name")
    private String userName;

    @JsonProperty(value="password")
    private String password;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
