package cn.gsq.service.impl;

import cn.gsq.dao.IRoleDao;
import cn.gsq.domain.Permission;
import cn.gsq.domain.Role;
import cn.gsq.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Permission> findRoleByIdAndAllPermission(String id) {
       List<Permission> list= roleDao.findRoleByIdAndAllPermission(id);
        return list;
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public void addRoleToUser(String id, String[] ids) {
        for (String pid:ids
             ) {
            roleDao.addPermissionToRole(id, pid);
        }
    }
}
