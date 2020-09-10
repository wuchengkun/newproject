package com.bjsxt.mapper;

import com.bjsxt.pojo.User;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserMapper extends JpaRepository<User,Integer> {
    @Query("from User where userName=?1 and password=?2 ")
    User loginByUsernameAndPassword(String userName,String password);
    @Query("update User set name= ?1,address=?2,sex=?3,email=?4 ,idCard=?5, phoneNumber=?6, nationality=?7  where id = ?8")
    @Modifying()
    @Transactional
    void updateUserNameById(String name,String address,String sex,String email,String idCard,String phoneNumber,String nationality ,Integer id);
    @Query("from User where id=?1")
    User findUserById(Integer id);
    @Query("from User where name=?1 and phoneNumber=?2 and idCard=?3")
    List<User> findUserByNameAndPhoneNumberAndIdCard(String name,String phoneNumber,String idCard);
}
