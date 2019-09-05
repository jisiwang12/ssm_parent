package cn.gsq.dao;

import cn.gsq.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {
    /**
     * 通过userId查询role表
     * @param id
     * @return
     */
    @Select("select * from role where id in(select ROLEID from USERS_ROLE where USERID=#{id})")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="roleName",property="roleName"),
            @Result(column="roleDesc",property="roleDesc"),
            @Result(column="id",property="permissions",javaType=List.class,many=@Many(select="cn.gsq.dao.IPermissionDao.findByRoleId"))
    })
    public List<Role> findRoleByUserId(String id);
}
