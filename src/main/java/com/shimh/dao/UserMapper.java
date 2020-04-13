package com.shimh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shimh.entity.User;

/**
 * @author shimh
 * <p>
 * 2018年1月23日
 */
public interface UserMapper extends JpaRepository<User, Long> {

    User findByAccount(String account);

}
