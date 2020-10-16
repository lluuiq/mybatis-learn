package com.lu.dao;

import com.lu.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Dao等价于mapper
 */
public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();

    // 方法存在多个参数，所有的参数前面都加上@Param
    @Select("select * from user where id = #{id}")
    User getUserByID(@Param("id") int id);

    @Insert("insert into user(id,username,password) values (#{id},#{username},#{pwd})")
    int addUser(User user);

    @Update("update user set username=#{username},password=#{pwd} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from user where id=#{id}")
    int deleteUser(@Param("id") int id);
}
