package com.xblog.modules.comment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xblog.modules.comment.entity.Comment;
import com.xblog.modules.comment.mapper.CommentMapper;
import com.xblog.modules.comment.service.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
