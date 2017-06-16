package com.todolist.controller;

import com.todolist.bean.UserRegistrationBean;
import com.todolist.entity.User;
import com.todolist.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "get user", httpMethod = "GET")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }
}
