package com.shimh.service.impl;

import com.shimh.entity.Log;
import com.shimh.dao.LogMapper;
import com.shimh.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shimh
 * <p>
 * 2018年4月18日
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public Integer saveLog(Log log) {
        return logMapper.save(log).getId();
    }
}
