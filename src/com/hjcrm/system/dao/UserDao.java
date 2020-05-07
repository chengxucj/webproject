package com.hjcrm.system.dao;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.system.bean.User;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface UserDao {
    User login(User user);
    User findUserByemail(String email);
    List<User> queryUserList(PageBean pageBean);
    int saveOrUpdate(User user);
    int queryAllUserCount();
    int deleteUser(List<Integer> list);
    int saveOrUpdate2(User user);

    Integer queryPwdByid(@Param("oldpwd") String oldpwd,@Param("userid") int userid);
    int editPassword(@Param("newpassword") String newpassword,@Param("userid") int userid);
}
