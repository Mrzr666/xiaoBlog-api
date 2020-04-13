package com.shimh.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shimh.common.util.PasswordHelper;
import com.shimh.entity.User;
import com.shimh.dao.UserMapper;
import com.shimh.service.UserService;

/**
 * @author shimh
 * <p>
 * 2018年1月23日
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User getUserByAccount(String account) {
        return userMapper.findByAccount(account);
    }

    @Override
    public User getUserById(Long id) {

        return userMapper.findOne(id);
    }

    @Override
    @Transactional
    public Long saveUser(User user) {

        PasswordHelper.encryptPassword(user);
        int index = new Random().nextInt(6) + 1;
        String avatar = "/static/user/user_" + index + ".png";

        user.setAvatar(avatar);
        return userMapper.save(user).getId();
    }


    @Override
    @Transactional
    public Long updateUser(User user) {
        User oldUser = userMapper.findOne(user.getId());
        oldUser.setNickname(user.getNickname());

        return oldUser.getId();
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userMapper.delete(id);
    }

}
