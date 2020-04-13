package com.xblog.modules.log.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xblog.modules.log.entity.Log;
import com.xblog.modules.log.mapper.LogMapper;
import com.xblog.modules.log.service.LogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xsy
 * @since 2020-04-13
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

    @Override
    public Integer saveLog(Log log) {
        int i = baseMapper.insert(log);
        return i;
    }
}
