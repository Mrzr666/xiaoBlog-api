package com.xblog.modules.tag.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xblog.modules.tag.entity.Tag;
import com.xblog.modules.tag.mapper.TagMapper;
import com.xblog.modules.tag.service.TagService;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
