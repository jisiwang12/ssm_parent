package cn.gsq.service;

import cn.gsq.domain.Permission;
import cn.gsq.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRoleService {
    public List<Role> findAll();

    void save(Role role);

    List<Permission> findRoleByIdAndAllPermission(String id);

    Role findById(String id);

    void addRoleToUser(String id, String[] ids);
}
