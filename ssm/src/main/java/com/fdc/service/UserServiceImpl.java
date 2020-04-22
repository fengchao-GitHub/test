package com.fdc.service;

import com.fdc.bean.User;
import com.fdc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    /*
        添加
        发生空指针异常会进行回滚
     */
    @Transactional(rollbackFor = NullPointerException.class)
    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public List<User> selectlike(String userId) {
        return userDao.selectlike(userId);
    }

    @Override
    public int ifExist(String userId) {
        return userDao.ifExist(userId);
    }

    /*
        删除
     */
    public void deleteById(String userId){
        userDao.deleteById(userId);
    }

    /*
        更新
     */
    @Override
    public void update(User user) {
        userDao.deleteById(user.getUserId());
        userDao.update(user);
    }

      /*
        查询全部用户
     */

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    /*
        根据id 查询用户
     */
    @Override
    public User selectById(String userId) {
        return userDao.selectById(userId);
    }

}
