package cn.gsq.controller;

import cn.gsq.dao.IPermissionDao;
import cn.gsq.domain.Permission;
import cn.gsq.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionContrller {
    @Autowired
    IPermissionService permissionService;
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<Permission> perminssionList=permissionService.findAll();
        mv.addObject("permissionList", perminssionList);
        mv.setViewName("permission-list");
        return mv;

    }

    @RequestMapping("/save")
    public String save(Permission permission) {
        permissionService.save(permission);
        return "redirect:findAll";
    }
}

