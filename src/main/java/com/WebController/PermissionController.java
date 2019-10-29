package com.WebController;

import com.Domain.Permission;
import com.Service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/addPermission.do")
    public ModelAndView addPermission(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("permission-add");
        return mv;
    }

    @RequestMapping("/savePermisssion.do")
    public String savePermission(Permission permission){
        permissionService.savePermission(permission);
        return "redirect:findAll.do";
    }
}
