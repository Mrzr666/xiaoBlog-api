package com.xblog.modules.article.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author xsy
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("me_article")
public class Article implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章简介
     */
    private String summary;

    /**
     * 评论数
     */
    private Integer commentCounts;

    /**
     * 文章浏览数
     */
    private Integer viewCounts;

    private Integer weight;

    /**
     * 作者id
     */
    private Long authorId;

    /**
     * 文章内容id
     */
    private Long bodyId;

    /**
     * 分类id
     */
    private Integer categoryId;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 删除标记
     */
    private String deleted;


}
