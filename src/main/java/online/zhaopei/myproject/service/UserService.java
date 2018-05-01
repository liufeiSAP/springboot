package online.zhaopei.myproject.service;

import online.zhaopei.myproject.domain.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void delete(String userId);
    void update(User user);
    List<User> search(String userId);
}
