package cn.gsq.service;

import cn.gsq.domain.Permission;

import java.util.List;

public interface IPermissionService {

    public List<Permission> findAll();

    public void save(Permission permission);
}
