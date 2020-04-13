package com.shimh.dao;

import com.shimh.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shimh
 * <p>
 * 2018年4月18日
 */
public interface LogMapper extends JpaRepository<Log, Integer> {
}
