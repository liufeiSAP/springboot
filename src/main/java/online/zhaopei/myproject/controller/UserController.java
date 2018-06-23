package online.zhaopei.myproject.controller;

import online.zhaopei.myproject.domain.ArchiveRecord;
import online.zhaopei.myproject.domain.User;
import online.zhaopei.myproject.dtos.ResponseJson;
import online.zhaopei.myproject.dtos.UserDto;
import online.zhaopei.myproject.service.MailService;
import online.zhaopei.myproject.service.UserService;
import org.codehaus.jackson.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService  userService;

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/users", method = RequestMethod.POST )
    @CrossOrigin
    public ResponseEntity<ResponseJson> addUser(@RequestBody User user) {

        mailService.sendMail();
        userService.addUser(user);
        ResponseJson response = new ResponseJson();
        response.setStatus("1");
        response.setMessage("success");
        return new ResponseEntity<ResponseJson>(response, HttpStatus.OK );
    }


    @RequestMapping(value = "/admin/login", method = RequestMethod.POST )
    @CrossOrigin
    public ResponseEntity<ResponseJson> login(@RequestBody UserDto userInfo) {
        List<User> users = userService.search(userInfo.getUserName());
        if (CollectionUtils.isEmpty(users)) {
            ResponseJson response = new ResponseJson();
            response.setStatus("0");
            response.setMessage("用户不存在");
           return new ResponseEntity<ResponseJson>(response, HttpStatus.valueOf(401));
        }

        if (users.get(0).getPassword().equals(userInfo.getPassword()) ) {
            ResponseJson response = new ResponseJson();
            response.setStatus("1");
            response.setMessage("success");
            return new ResponseEntity<ResponseJson>(response, HttpStatus.OK );
        }

        ResponseJson response = new ResponseJson();
        response.setStatus("0");
        response.setMessage("密码错误");

        return new ResponseEntity<ResponseJson>(response, HttpStatus.valueOf(401) );
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
