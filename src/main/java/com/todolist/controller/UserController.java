package com.todolist.controller;

import com.todolist.bean.UserRegistrationBean;
import com.todolist.entity.User;
import com.todolist.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@Api(value = "users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "create user", httpMethod = "POST")
    public void createUser(@RequestBody UserRegistrationBean userRegistrationBean) {
        userService.createUser(userRegistrationBean);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "get user", httpMethod = "GET")
    public User getUser(Authentication authentication) {

        return userService.getUser(authentication.getName());
    }
}
