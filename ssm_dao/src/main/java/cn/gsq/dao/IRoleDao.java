package cn.gsq.dao;

import cn.gsq.domain.Permission;
import cn.gsq.domain.Role;
import org.apache.ibatis.annotations.*;

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

    @Select("select * from ROLE")
    List<Role> findAll();

    @Insert("insert into ROLE (rolename, roledesc) VALUES (#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from PERMISSION where ID not in (select PERMISSIONID from ROLE_PERMISSION where ROLEID=#{id})")
    List<Permission> findRoleByIdAndAllPermission(String id);

    @Select("select * from role where id=#{id}")
    Role findById(String id);

    @Insert("insert into ROLE_PERMISSION(ROLEID, PERMISSIONID) values (#{id},#{pid})")
    void addPermissionToRole(@Param("id") String id, @Param("pid") String pid);
}
