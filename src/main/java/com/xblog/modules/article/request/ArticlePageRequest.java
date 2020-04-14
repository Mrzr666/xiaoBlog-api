package com.xblog.modules.article.request;

import com.xblog.modules.article.entity.Article;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ArticlePageRequest extends Article implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer year;

    private Integer month;

    private Integer tagId;

    private Integer categoryId;

    private Integer count;
}
