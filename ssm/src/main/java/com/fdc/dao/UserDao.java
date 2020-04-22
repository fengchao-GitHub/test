package com.fdc.dao;

import com.fdc.bean.User;

import java.util.List;

public interface UserDao {

    void insert(User user);

    List<User> selectlike(String userId);

    int ifExist(String userId);

    void deleteById(String userId);

    void update(User user);

    List<User> selectAll();

    User selectById(String userId);
}
