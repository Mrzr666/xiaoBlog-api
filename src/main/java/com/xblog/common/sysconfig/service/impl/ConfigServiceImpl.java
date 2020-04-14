package com.xblog.common.sysconfig.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xblog.common.sysconfig.entity.Config;
import com.xblog.common.sysconfig.mapper.ConfigMapper;
import com.xblog.common.sysconfig.service.ConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xsy
 * @since 2020-04-14
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements ConfigService {

    @Override
    public String queryValueByKey(String key) {
        LambdaQueryWrapper<Config> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Config::getKey,key);
        Config config = getBaseMapper().selectOne(wrapper);
        if (null != config){
            return config.getValue();
        }
        return "";
    }
}
