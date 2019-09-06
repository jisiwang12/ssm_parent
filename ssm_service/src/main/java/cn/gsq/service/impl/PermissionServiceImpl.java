package cn.gsq.service.impl;

import cn.gsq.dao.IPermissionDao;
import cn.gsq.domain.Permission;
import cn.gsq.domain.Product;
import cn.gsq.service.IPermissionService;
import cn.gsq.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}
