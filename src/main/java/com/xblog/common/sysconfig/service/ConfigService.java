package com.xblog.common.sysconfig.service;

import com.xblog.common.sysconfig.entity.Config;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xsy
 * @since 2020-04-14
 */
public interface ConfigService extends IService<Config> {
    String queryValueByKey(String key);

}
