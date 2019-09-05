package cn.gsq.dao;

import cn.gsq.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {
    @Select("select * from role where id in(select ROLEID from USERS_ROLE where USERID=#{id})")
    public List<Role> findRoleByUserId(String id);
}
