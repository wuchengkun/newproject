package com.bjsxt.service.Impl;

import com.bjsxt.mapper.UserMapper;
import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User addUser(User user) {
        return userMapper.save(user);
    }

    @Override
    public User login(String userName,String password) {
        return userMapper.loginByUsernameAndPassword(userName,password);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void update(String name,String address,String sex,String email,String idCard,String phoneNumber,String nationality ,Integer id) {
        userMapper.updateUserNameById(name, address, sex, email, idCard, phoneNumber, nationality, id);
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public void delUserById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public List<User> findUserByNameAndPhoneNumberAndIdCard(String name, String phoneNumber, String idCard) {
        return userMapper.findUserByNameAndPhoneNumberAndIdCard(name,phoneNumber,idCard);
    }
}
