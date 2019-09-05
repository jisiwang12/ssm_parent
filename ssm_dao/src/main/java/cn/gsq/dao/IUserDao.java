package cn.gsq.dao;

import cn.gsq.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


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
}
