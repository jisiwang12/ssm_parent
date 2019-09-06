package cn.gsq.dao;

import cn.gsq.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})")
    public List<Permission> findByRoleId(String roleId);

    @Select("select * from PERMISSION")
    public List<Permission> findAll();
    @Insert("insert into PERMISSION (PERMISSIONNAME, URL) values (#{permissionName},#{url})")
    public void save(Permission permission);
}
