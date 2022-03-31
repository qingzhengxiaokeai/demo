package com.scut.service;


import com.scut.entity.User;
import com.scut.util.PageBean;

import java.util.List;
import java.util.Map;

public interface UserService {

     User getUser(Integer id);
//     Integer addUser(User user);
/*
 * 新增一个用户
 * */
    Integer insertOne(User user);

     /*
      * 新增多个用户
      * */
     Integer insertMany(List<User> userList);

     Integer deleteUser(Integer id);

     Integer updateUser(User user);

    /*
     * 分页查询1
     * @param 起始页面
     * @param 数据条数
     * */
    List<User> selectForPage1(Integer startIndex , Integer pageSize);

    //分页查询  通过map进行查询
    List<User> selectForPage2(Map<String,Object> map);

    //查询总条数
    public Integer selectCount();

    //分页查询3 对象
    List<User> selectByPageBean(PageBean pageBean);

    List<User> selectByLike(Map<String,Object> map);

    Integer selectCount2(String keywords);
}
