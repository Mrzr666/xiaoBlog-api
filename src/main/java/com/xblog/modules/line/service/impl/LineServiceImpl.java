package com.xblog.modules.line.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xblog.common.result.Result;
import com.xblog.modules.line.entity.Line;
import com.xblog.modules.line.mapper.LineMapper;
import com.xblog.modules.line.service.LineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xsy
 * @since 2020-04-15
 */
@Service
public class LineServiceImpl extends ServiceImpl<LineMapper, Line> implements LineService {

    @Override
    public Result createLine(Line line) {
        Integer result = baseMapper.insert(line);
        if (result != null && result > 0){
            return Result.success("新增成功！");
        }
        return Result.error("新增失败！");
    }

    @Override
    public Result queryLineList() {
        LambdaQueryWrapper<Line> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Line::getDeleted,false);
        wrapper.orderByDesc(Line::getMarkTime);
        List<Line> datas = getBaseMapper().selectList(wrapper);
        return Result.success(datas);
    }
}
