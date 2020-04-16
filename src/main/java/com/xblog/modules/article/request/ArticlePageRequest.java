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

    private String name;

    private String sort;

    /**
     * 每页显示大小
     */
    private Integer  pageSize;

    /**
     * 当前页码
     */
    private  Integer pageNumber;

    /**
     * 最大页数
     */
    private  Integer maxCurrent;

    private Integer offset;

    /**
     * 数据总条数
     */
    private  Integer total;
}
