package com.WebController;

import com.Dao.RoleDao;
import com.Domain.Role;
import com.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){

        ModelAndView mv = new ModelAndView();

        List<Role> roleList = roleService.findAll();

        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");

        return mv;
    }


    @RequestMapping("/addRole.do")
    public ModelAndView addRole(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("role-add");
        return mv;
    }

    @RequestMapping("/save.do")
    public String saveRole(Role role){
        roleService.addRole(role);
        return "redirect:findAll.do";
    }
}
