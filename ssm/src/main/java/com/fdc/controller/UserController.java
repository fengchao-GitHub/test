package com.fdc.controller;

import com.alibaba.fastjson.JSON;
import com.fdc.bean.User;
import com.fdc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    rest风格的controller
 */
@RestController
public class UserController {

    @Autowired//注入userService
    private UserService userService;

    /*
        查询全部用户
     */
    @GetMapping("/user")
//    @RequestMapping("/findAll")
    public String findAll()throws Exception{

        List<User> allUser = userService.selectAll();

        //将数据转成json格式
        String jsonStr = JSON.toJSONString(allUser);

        System.out.println(jsonStr);

        return jsonStr;
    }


    /*
        根据id查询
     */
    @GetMapping(value = "user/{userId}")
    public String findUserById(@PathVariable String userId)throws Exception {
        User user = userService.selectById(userId);
        String jsonStr = JSON.toJSONString(user);
        return jsonStr;
    }

    /*
        模糊查询
     */
    @GetMapping(value = "like/{userId}")
    public String selectLike(@PathVariable String userId)throws Exception {
        System.out.println(userId);
        List<User> userList = userService.selectlike(userId);
        String jsonStr = JSON.toJSONString(userList);
        System.out.println(userList);
        return jsonStr;
    }

    /*
        判断用户名是否存在
     */
    @GetMapping(value = "ifexist/{userId}")
    public String ifExist(@PathVariable String userId)throws Exception {

        System.out.println(userId);

        int count = userService.ifExist(userId);

        String jsonStr = JSON.toJSONString(count);
        System.out.println(jsonStr);
        return jsonStr;
    }

    /*
        新增
     */
    @PostMapping("/user")
    public String create(@RequestBody User user)throws Exception{
        try {
            userService.insert(user);
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }

        return JSON.toJSONString("success");
    }

    /*
        修改
     */
    @PutMapping("/user/{userId}")
    public String update(@PathVariable String userId,@RequestBody User user)throws Exception{

        try {
            //将id赋值到user对象中
            user.setUserId(userId);
            userService.update(user);
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }

        return JSON.toJSONString("success");
    }

    /*
        删除
     */
    @DeleteMapping("/user/{userId}")
    public String delete(@PathVariable String userId)throws Exception{
        try {
            userService.deleteById(userId);
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }

        return JSON.toJSONString("success");
    }
}
