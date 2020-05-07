package com.hjcrm.system.service.impl;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.publics.utils.SplitIdsUtil;
import com.hjcrm.system.bean.User;
import com.hjcrm.system.dao.UserDao;
import com.hjcrm.system.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User findUserByemail(String email) {
        return userDao.findUserByemail(email);
    }

    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public List<User> queryUserList(PageBean pageBean) {

        return userDao.queryUserList(pageBean);
    }

    @Override
    public int saveOrUpdate(User user) {
        if(user!=null){
            if(user.getUserid()!=0){
                return userDao.saveOrUpdate2(user);
            }else{
                return userDao.saveOrUpdate(user);
            }
        }
        return -1;
    }

    @Override
    public int queryAllUserCount() {
        return userDao.queryAllUserCount();
    }

    @Override
    public int deleteUser(String ids) {
        List<Integer> list=SplitIdsUtil.SplitIdstoList(ids);
        return userDao.deleteUser(list);
    }

    @Override
    public Integer queryPwdByid(String oldpwd,int userid) {
        return userDao.queryPwdByid(oldpwd,userid);
    }

    @Override
    public int editPassword(String newpassword, int userid) {
        return userDao.editPassword(newpassword,userid);
    }
}
