package com.hjcrm.system.service;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.system.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    User findUserByemail(String email);
    User login(User user);
    List<User> queryUserList(PageBean pageBean);
    int saveOrUpdate(User user);
    int queryAllUserCount();
    int deleteUser(String str);

    Integer queryPwdByid(String oldpwd,int userid);
    int editPassword(String newpassword,int userid);
}
