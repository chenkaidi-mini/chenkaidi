package com.qianfeng.controller;

import com.qianfeng.pojo.User;
import com.qianfeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author 臧红久
 * @Date 2019/10/15
 * @Version V1.0
 **/
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("users")
    public String queryAllUsers(Model model){
        List<User> users = userService.selectAllUsers();
        model.addAttribute("users",users);
        return "forward:/WEB-INF/users.jsp";
    }

    @PostMapping("regist")
    public String saveUser(User user){
        userService.insertUser(user);
//        return "redirect:/users";
        return "index";
    }

    @GetMapping("regist")
    public String registPage(){
        return "forward:/WEB-INF/regist.jsp";
    }
}
