package com.xblog.modules.line.service;

import com.xblog.common.result.Result;
import com.xblog.modules.line.entity.Line;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xsy
 * @since 2020-04-15
 */
public interface LineService extends IService<Line> {
    Result createLine(Line line);
    Result queryLineList();

}
