package com.WebController;

import com.Dao.UserDao;
import com.Domain.Image;
import com.Domain.Role;
import com.Domain.UserInfo;
import com.Domain.UserTest;
import com.Service.ImgService;
import com.Service.RoleService;
import com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
@SessionAttributes(value = {"SesssionUsername","SesssionPassword"})
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ImgService imgService;


    @RequestMapping("/main.do")
    public ModelAndView toMainJsp(Model model, String username, String password){
        ModelAndView mv = new ModelAndView();
        Date date = new Date();
        mv.addObject("date",date);
        mv.addObject("price",11.98524);
        mv.setViewName("testAjaxandJson");
        List<Image> imglist = imgService.findAll();
        mv.addObject("listImg",imglist);

        model.addAttribute("SesssionUsername",username);
        password = userService.encodePwd(password);
        model.addAttribute("SesssionPassword",password);
        return mv;
    }

    @RequestMapping("/doajax.do")
    public @ResponseBody UserTest doajax(@RequestBody UserTest json){
        System.out.println("--------------------------------------------------------------------------------------");
//      参数用String json
//      try {
//            String json1 = URLDecoder.decode(json,"utf-8");
//            System.out.println(json1);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println(json);
        System.out.println("--------------------------------------------------------------------------------------");
        return json;


    }

    @RequestMapping("/toajax.do")
    public ModelAndView toajax(){
        Date date = new Date();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("testAjaxandJson");
        mv.addObject("date",date);
        mv.addObject("price",11.98524);
        return mv;
    }


    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){

        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfos = userService.findAll();
        mv.addObject("userInfos",userInfos);
        mv.setViewName("user-list");

        return mv;
    }

    @RequestMapping("/saveUser.do")
    public String addUser(UserInfo userInfo){
        ModelAndView mv = new ModelAndView();
        userService.addUser(userInfo);
        //System.out.println(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/addUser.do")
    public ModelAndView addUser() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-add");
        return mv;
    }

    @RequestMapping("findById.do")
    public ModelAndView findById(Integer id){

        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);

        mv.addObject("userInfo",userInfo);
        mv.setViewName("user-show");

        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(value = "id",defaultValue = "1",required = true) Integer userId){

        UserInfo userInfo = userService.findById(userId);
        List<Role> roles = roleService.findOtherRoles(userId);
        for(Role role:roles)
        System.out.println(role);
        ModelAndView mv = new ModelAndView();
        mv.addObject("userInfo",userInfo);
        mv.addObject("roles",roles);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRolesToUser.do")
    public String addRolesToUser(Integer userId,Integer[] ids){

        if(ids!=null){
            for(Integer ID:ids){
                userService.addRolesToUser(userId,ID);
            }
        }

        return "redirect:findAll.do";
    }

    @RequestMapping("/changePassword.do")
    public ModelAndView goChangeJsp(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("changePwd");
        return mv;
    }

    @RequestMapping("/getNewPassword.do")
    public String getNewPassword(@RequestParam(value = "reNewPassword") String newPwd, String username){
        newPwd = userService.encodePwd(newPwd);
        userService.UpdateNewPwdByName(newPwd,username);


        return "redirect:/logout.do";
    }

    @RequestMapping("/checkFrom.do")
    public @ResponseBody Map<String, String> checkFrom(@RequestBody Map<String,String> map){
        System.out.println("??????????????????????????????????????????????????????????????");
        System.out.println(map);
        System.out.println("??????????????????????????????????????????????????????????????");
        boolean check = false;
        String username = map.get("name");
        String password = map.get("pwd");
        if(userService.checkInfo(username,password))
            check = true;
        Map<String,String> map1 = new HashMap<>();
        map1.put("check",String.valueOf(check));
        return map1;
    }
}

