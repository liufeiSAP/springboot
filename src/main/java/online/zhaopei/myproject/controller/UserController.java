package online.zhaopei.myproject.controller;

import online.zhaopei.myproject.domain.ArchiveRecord;
import online.zhaopei.myproject.domain.User;
import online.zhaopei.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService  userService;

    @RequestMapping(value = "/users", method = RequestMethod.POST )
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "OK";
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE )
    public String deleteUser(@PathVariable String userId) {
        userService.delete(userId);
        return "ok";
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT )
    public String updateUser(@RequestBody User user) {
        userService.update(user);
        return "ok";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET )
    public List<User>  getUsers(@RequestParam(required=false) String userId) {
        return userService.search(userId);
    }
}
