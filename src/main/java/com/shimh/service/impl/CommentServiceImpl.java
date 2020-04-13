package com.shimh.service.impl;

import java.util.Date;
import java.util.List;

import com.shimh.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shimh.common.util.UserUtils;
import com.shimh.entity.Article;
import com.shimh.entity.Comment;
import com.shimh.dao.ArticleMapper;
import com.shimh.dao.CommentMapper;
import com.shimh.service.CommentService;

/**
 * @author shimh
 * <p>
 * 2018年1月25日
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> findAll() {
        return commentMapper.findAll();
    }

    @Override
    public Comment getCommentById(Integer id) {
        return commentMapper.getOne(id);
    }

    @Override
    @Transactional
    public Integer saveComment(Comment comment) {

        return commentMapper.save(comment).getId();
    }


    @Override
    @Transactional
    public void deleteCommentById(Integer id) {
        commentMapper.delete(id);
    }

    @Override
    public List<Comment> listCommentsByArticle(Integer id) {
        Article a = new Article();
        a.setId(id);
        return commentMapper.findByArticleAndLevelOrderByCreateDateDesc(a, "0");
    }

    @Override
    @Transactional
    public Comment saveCommentAndChangeCounts(Comment comment) {

        int count = 1;
        Article a = articleMapper.findOne(comment.getArticle().getId());
        a.setCommentCounts(a.getCommentCounts() + count);

        comment.setAuthor(UserUtils.getCurrentUser());
        comment.setCreateDate(new Date());

        //设置level
        if(null == comment.getParent()){
            comment.setLevel("0");
        }else{
            if(null == comment.getToUser()){
                comment.setLevel("1");
            }else{
                comment.setLevel("2");
            }
        }

        return commentMapper.save(comment);

    }

    @Override
    @Transactional
    public void deleteCommentByIdAndChangeCounts(Integer id) {
        int count = 1;
        Comment c = commentMapper.findOne(id);
        Article a = c.getArticle();

        a.setCommentCounts(a.getCommentCounts() - count);

        commentMapper.delete(c);
    }


}
