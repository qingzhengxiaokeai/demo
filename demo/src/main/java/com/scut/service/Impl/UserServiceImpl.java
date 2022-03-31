package com.scut.service.Impl;

import com.scut.entity.User;
import com.scut.mapper.UserMapper;
import com.scut.service.UserService;
import com.scut.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired  //自动导入对象到类中，被注入进的类同样要被 Spring 容器管理
    private UserMapper userMapper;


    @Override
    public User getUser(Integer id) {
        User user = userMapper.getUser(id);
        return user;
    }

    @Override
    public Integer insertOne(User user){
        return userMapper.insertOne(user);
    }

    @Override
    public Integer insertMany(List<User> userList){
        return userMapper.insertMany(userList) ;
    }

    @Override
    public Integer deleteUser(Integer id){
        return userMapper.deleteUser(id) ;
    }

    @Override
    public Integer updateUser(User user){
        //User user=userMapper.updateUser(String username);
        return userMapper.updateUser(user) ;
    }

    @Override
    public List<User> selectForPage1(Integer startIndex , Integer pageSize){
        return userMapper.selectForPage1(startIndex , pageSize) ;

    }

    @Override
    public List<User> selectForPage2(Map<String,Object> map){
        return userMapper.selectForPage2(map);
    }

    @Override
    public Integer selectCount(){
        return userMapper.selectCount();
    }

    @Override
    public List<User> selectByPageBean(PageBean pageBean){
        return userMapper.selectByPageBean(pageBean);
    }

    @Override
    public List<User> selectByLike(Map<String,Object> map){
        return userMapper.selectByLike(map);
    }

    @Override
    public Integer selectCount2(String keywords){
        return userMapper.selectCount2(keywords);
    }

}
