package online.zhaopei.myproject.service.impl;

import online.zhaopei.myproject.domain.User;
import online.zhaopei.myproject.mapper.primary.CityMapper;
import online.zhaopei.myproject.mapper.primary.UserMapper;
import online.zhaopei.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void delete(String userId) {
        userMapper.deleteUser(userId);
    }

    @Override
    public void update(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public List<User> search(String userId) {
        return userMapper.searchUser(userId);
    }
}
