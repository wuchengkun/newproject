package com.bjsxt.controller;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userServiceImpl;
    @RequestMapping("/{page}")
    public String page(@PathVariable String page,User user){
        return page;
    }

    /**
     * 添加用户
     * @param user
     * @param result
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(@Valid User user, BindingResult result){
        if(result.hasErrors()){
            return "add";
        }else {
            userServiceImpl.addUser(user);
            return "ok";
        }
    }

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("/userlogin")
    public String login(String userName,String password){
        User login = userServiceImpl.login(userName,password);
        if(login!=null){
            return "find";
        }else {
            return "login";
        }
    }

    /**
     * 查询全部
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<User> list = userServiceImpl.findAll();
        model.addAttribute("list",list);
        return "showUser";
    }

    /**
     * 修改用户需要的查询用户
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/findUserById")
    public String updateUser(Integer id,Model model){
        User user = userServiceImpl.findUserById(id);
        model.addAttribute("user",user);
        return "updateUser";
    }

    /**
     * 修改用户
     * @param name
     * @param address
     * @param sex
     * @param email
     * @param idCard
     * @param phoneNumber
     * @param nationality
     * @param id
     * @return
     */
    @RequestMapping("/update")
    public String update(String name,String address,String sex,String email,String idCard,String phoneNumber,String nationality ,Integer id){
            userServiceImpl.update(name, address, sex, email, idCard, phoneNumber, nationality, id);
            return "ok";
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping("delUserById")
    public String delUserById(Integer id){
        userServiceImpl.delUserById(id);
        return "redirect:/user/findAll";
    }

    /**
     * 按条件查询
     * @param name
     * @param phoneNumber
     * @param idCard
     * @param model
     * @return
     */
    @RequestMapping("/findUserByNameAndPhoneNumberAndIdCard")
    public String findUserByNameAndPhoneNumberAndIdCard(String name,String phoneNumber,String idCard,Model model){
        List<User> find = userServiceImpl.findUserByNameAndPhoneNumberAndIdCard(name, phoneNumber, idCard);
            model.addAttribute("findByName",find);
            return "findUser";
    }

    /**
     * 按条件查询后执行删除用户后的页面跳转
     * @param id
     * @return
     */
    @RequestMapping("delUserByfind")
    public String delUserById2(Integer id){
        userServiceImpl.delUserById(id);
        return "redirect:/user/findUserByNameAndPhoneNumberAndIdCard";
    }
}
