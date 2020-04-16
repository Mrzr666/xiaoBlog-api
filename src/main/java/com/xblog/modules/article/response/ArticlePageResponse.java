package com.xblog.modules.article.response;

import com.xblog.modules.article.entity.Article;
import com.xblog.modules.article.entity.ArticleBody;
import com.xblog.modules.category.entity.Category;
import com.xblog.modules.comment.entity.Comment;
import com.xblog.modules.tag.entity.Tag;
import com.xblog.modules.user.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ArticlePageResponse extends Article {


    private List<Tag> tags;

    private List<Comment> comments;

    private ArticleBody body;

    private User author;

    private Category category;

    private Integer year;

    private Integer month;

    private Integer count;
}
