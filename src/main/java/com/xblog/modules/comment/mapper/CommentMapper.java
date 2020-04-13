package com.xblog.modules.comment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xblog.modules.comment.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xsy
 * @since 2020-04-13
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
