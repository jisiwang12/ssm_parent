package cn.gsq.controller;

import cn.gsq.domain.Permission;
import cn.gsq.domain.Role;
import cn.gsq.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    IRoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("role-list");
        List<Role> list = roleService.findAll();
        modelAndView.addObject("roleList", list);
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:findAll";
    }

    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(String id) {
        ModelAndView mv = new ModelAndView();
        Role role=roleService.findById(id);
        List<Permission> permissionList=roleService.findRoleByIdAndAllPermission(id);
        mv.addObject("permissionList", permissionList);
        mv.addObject("role", role);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/addPermissionToRole")
    public String addRoleToUser(@RequestParam(name = "roleId" ,required = true) String id, @RequestParam(name = "ids",required = true) String[] ids) {
        roleService.addRoleToUser(id, ids);
        return "redirect:findAll";


    }
}
