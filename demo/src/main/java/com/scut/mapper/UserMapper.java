package com.scut.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scut.entity.User;
import com.scut.util.PageBean;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;
@Repository
public interface UserMapper extends BaseMapper<User> {

    User getUser(Integer id);
    public Integer insertOne(User user);
    public Integer insertMany(List<User> userList);
    Integer deleteUser(Integer id);
    Integer updateUser(User user);
    //分页查询 通过开始页和数据条数进行查询
    List<User> selectForPage1(Integer startIndex , Integer pageSize) ;
    List<User> selectForPage2(Map<String,Object> map) ;
    Integer selectCount();
    List<User> selectByPageBean(PageBean pageBean);
    List<User> selectByLike(Map<String,Object> map);
    Integer selectCount2(String keywords);
}
