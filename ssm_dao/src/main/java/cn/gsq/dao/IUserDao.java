package cn.gsq.dao;

import cn.gsq.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.userdetails.User;

import java.util.List;


/**
 * 用户登录
 */
public interface IUserDao {
    /**
     * 通过username查找用户
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from USERS where USERNAME=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.gsq.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findUserByUsername(String username) throws Exception;

    @Select("select * from USERS")
    public List<UserInfo> findAll();

    @Insert("insert into USERS (EMAIL, USERNAME, PASSWORD, PHONENUM, STATUS) VALUES (#{email},#{username}," +
            "#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);


    @Select("select * from users where id=#{id}")
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "email",property = "email"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles" ,javaType = List.class,many = @Many(select = "cn.gsq.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(String id);
}
