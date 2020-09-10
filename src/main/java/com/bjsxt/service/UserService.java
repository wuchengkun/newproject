package com.bjsxt.service;

import com.bjsxt.pojo.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User login(String userName,String password);
    List<User> findAll();
    void update(String name,String address,String sex,String email,String idCard,String phoneNumber,String nationality ,Integer id);
    User findUserById(Integer id);
    void delUserById(Integer id);
    List<User> findUserByNameAndPhoneNumberAndIdCard(String name,String phoneNumber,String idCard);
}
