package com.example.core.system.controller;

import com.example.core.base.BaseController;
import com.example.core.constants.BaseEnums;
import com.example.core.base.Result;
import com.example.core.system.dto.User;
import com.example.core.system.service.UserService;
import com.example.core.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户Controller
 *
 * @version 1.0
 * @author bojiangzhou 2017-12-31
 */
@RequestMapping
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;


    @PostMapping("/sys/user/queryAll")
    public Result queryAll(){
        List<User> list = userService.selectAll();
        return Results.successWithData(list, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.description());
    }

    @RequestMapping("/sys/user/queryOne/{userId}")
    public Result queryOne(@PathVariable Long userId){
        User user = userService.get(userId);
        return Results.successWithData(user);
    }

    @PostMapping("/sys/user/save")
    public Result save(@Valid @RequestBody User user){
        user = userService.insertSelective(user);
        return Results.successWithData(user);
    }

    @PostMapping("/sys/user/update")
    public Result update(@Valid @RequestBody List<User> user){
        user = userService.persistSelective(user);
        return Results.successWithData(user);
    }

    @RequestMapping("/sys/user/delete")
    public Result delete(User user){
        userService.delete(user);
        return Results.success();
    }

    @RequestMapping("/sys/user/delete/{userId}")
    public Result delete(@PathVariable Long userId){
        userService.delete(userId);
        return Results.success();
    }

}