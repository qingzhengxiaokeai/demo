package com.scut.controller;

import com.scut.base.BaseEnum;
import com.scut.base.Result;
import com.scut.util.*;
import com.scut.util.Results;
import com.scut.constants.BaseEnums;
import com.scut.entity.User;
import com.scut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    @PostMapping("/getUser")
    public User getUser(@RequestParam("id") Integer id) {

        return userService.getUser(id);
    }

    /*
     * 插入一条数据
     * */
    @PostMapping("/insertOne")
    public Result InsertOne(@RequestBody User user){
        return Results.successWithData(userService.insertOne(user),
                BaseEnums.SUCCESS.code(),BaseEnums.SUCCESS.desc());
    }

    /*
     * 插入多条数据
     * */
    @PostMapping("/insertMany")

    public Result InsertMany(@RequestBody List<User> userlist){
        return Results.successWithData(userService.insertMany(userlist),
                BaseEnums.SUCCESS.code(),BaseEnums.SUCCESS.desc());
    }

    /*
     * 删除数据
     * */
    @PostMapping("/deleteUser")

    public Result deleteUser(@RequestParam("id") Integer id) {
        return Results.successWithData(userService.deleteUser(id),
                BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody User user) {
        Integer id=user.getId();
        User user1=userService.getUser(id);
        System.out.println(user1);
        if(user1!=null){
            return Results.successWithData(userService.updateUser(user),
                    BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
        }else{
            return Results.failure();
        }
        /*
         * 分页查询所有条数据
        * */
    }
    @PostMapping("/selectForPage1")
    public Result selectForPage1(@RequestParam("currentPage") Integer currentPage,
                                 @RequestParam("pageSize") Integer pageSize){
        //PageHelper.startPage(1,2);
        //List<User> userList = userService.select();
        List<User> selectForPage = userService.
                selectForPage1((currentPage-1)*pageSize, pageSize) ;
        for (User user : selectForPage) {
            System.out.println(user);
        }
        return Results.successWithData(selectForPage,
                BaseEnums.SUCCESS.code(),BaseEnums.SUCCESS.desc());
    }

    @PostMapping("/selectForPage2")
    public Result selectForPage2(@RequestParam("currentPage") Integer currentPage,
                                 @RequestParam("pageSize") Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        map.put("startIndex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);
        List<User> selectForPage=userService.selectForPage2(map);
        for(User user:selectForPage) {
            System.out.println(user);
        }
        return Results.successWithData(selectForPage,BaseEnums.SUCCESS.code(),BaseEnums.SUCCESS.desc());

    }

    @PostMapping("/selectByPageBean")
    public Result selsctByPageBean(@RequestParam("currentPage") Integer currentPage,
                                   @RequestParam("pageSize") Integer pageSize){
        PageBean pageBean=new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        Integer count =userService.selectCount();
        pageBean.setTotalCount(count);
        List<User> userList=userService.selectByPageBean(pageBean);
        for(User user:userList){
            System.out.println(user);
        }
        System.out.println("当前第"+pageBean.getCurrentPage()+"页，共"+count+"条");
        return Results.successWithData(userList,BaseEnums.SUCCESS.code(),BaseEnums.SUCCESS.desc());
    }
    
    @PostMapping("/selectByLike")
    public Result selectByLike(@RequestParam("keywords") String keywords,
                               @RequestParam("currentPage") Integer currentPage,
                               @RequestParam("pageSize") Integer pageSize){
        PageBean pageBean=new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currentPage);
        Integer count=userService.selectCount2(keywords);
        pageBean.setTotalCount(count);
        Map<String,Object> map=new HashMap<>();
        map.put("startIndex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);
        map.put("count",count);
        List<User> userList=userService.selectByLike(map);
        for(User user:userList){
            System.out.println(user);
        }
        System.out.println("当前第"+pageBean.getCurrentPage()+"页，共"+count+"条");
        return Results.successWithData(userList,BaseEnums.SUCCESS.code(),BaseEnums.SUCCESS.desc());
    }
}
